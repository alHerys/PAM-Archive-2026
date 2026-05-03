package com.example.tugaspraktikum.modulPraktikum.modul2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugaspraktikum.modulPraktikum.modul2.ui.theme.TugasPraktikumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("LIFECYCLE_TEST", "onCreate dipanggil")
        setContent {
            HalamanUtama()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE_TEST", "onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE_TEST", "onResume dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE_TEST", "onPause dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE_TEST", "onStop dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE_TEST", "onDestroy dipanggil")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TugasPraktikumTheme {
        Greeting("Android")
    }
}