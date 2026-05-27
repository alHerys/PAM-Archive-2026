package com.example.tugaspraktikum.modul9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.tugaspraktikum.modul9.data.repositories.BookRepository
import com.example.tugaspraktikum.modul9.ui.screen.BookScreen
import com.example.tugaspraktikum.modul9.ui.theme.TugasPraktikumTheme
import com.example.tugaspraktikum.modul9.viewmodel.BookViewModel
import com.example.tugaspraktikum.modul9.viewmodel.BookViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var bookViewModel: BookViewModel
    private lateinit var repository: BookRepository
    private lateinit var factory: BookViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = BookRepository()
        factory = BookViewModelFactory(repository)
        bookViewModel = ViewModelProvider(this, factory)[BookViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            TugasPraktikumTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BookScreen(innerPadding, bookViewModel)
                }
            }
        }
    }
}