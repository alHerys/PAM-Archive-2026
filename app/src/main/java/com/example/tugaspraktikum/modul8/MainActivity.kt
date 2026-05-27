package com.example.tugaspraktikum.modul8

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.tugaspraktikum.modul8.ui.theme.TugasPraktikumTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var bookViewModel: BookViewModel
    private lateinit var bookDatabase: BookDatabase
    private lateinit var repository: BookRepository
    private lateinit var factory: BookViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bookDatabase = BookDatabase(this)
        repository = BookRepository(bookDatabase)
        factory = BookViewModelFactory(repository)
        bookViewModel = ViewModelProvider(this, factory)[BookViewModel::class.java]

        setContent {
            TugasPraktikumTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),
                        bookViewModel = bookViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun BookCard(book: Book) {
    Card(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = "JUDUL " + book.title)
            Text(text = "ISBN " + book.isbn)
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, bookViewModel: BookViewModel) {
    val itemList by bookViewModel.getAllBook().collectAsStateWithLifecycle(initialValue = listOf())
    var title by remember { mutableStateOf("") }
    var isbn by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(all = 50.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("JUDUL") },
        )
        TextField(
            value = isbn,
            onValueChange = { isbn = it },
            label = { Text("ISBN") },
        )
        Button(onClick = {
            val book = Book(id = null, title = title, isbn = isbn)
            bookViewModel.insert(book)
        }) { Text(text = "SIMPAN") }
        LazyColumn {
            items(itemList) { book -> BookCard(book) }
        }
    }
}

@Entity(tableName = "book")
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val title: String?,
    val isbn: String?,
)

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM book ")
    fun getAllBooks(): Flow<List<Book>>
}

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDatabase : RoomDatabase() {
    abstract fun getBookDao(): BookDao

    companion object {
        private const val DB_NAME = "bookstore_database.db"

        @Volatile
        private var instance: BookDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, BookDatabase::class.java, DB_NAME
        ).build()
    }
}

class BookRepository(private val bookStoreDatabase: BookDatabase) {
    fun getAllBook(): Flow<List<Book>> = bookStoreDatabase.getBookDao().getAllBooks()
    suspend fun insertBook(book: Book) = bookStoreDatabase.getBookDao().insertBook(book)
}

class BookViewModel(
    private val repository: BookRepository
) : ViewModel() {
    fun getAllBook() = repository.getAllBook()
    fun insert(book: Book) {
        viewModelScope.launch {
            repository.insertBook(book)
        }
    }
}

class BookViewModelFactory(private val repository: BookRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            val constructor = modelClass.getDeclaredConstructor(BookRepository::class.java)
            return constructor.newInstance(repository)
        } catch (e: Exception) {
            Log.e("ERROR", e.message.toString())
        }
        return super.create(modelClass)
    }
}
