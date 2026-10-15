package com.example.first

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first.ui.theme.FirstTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun glbool(modifier: Modifier = Modifier){
    val chInput = remember { mutableStateOf("") }
    val res = remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = chInput.value,
            onValueChange = {chInput. value = it},
            label = {Text("Введите символ")}
        )

        Button(onClick = {
            val ch = chInput.value.toCharArray()
            if (ch == null) {
                res.value = "Введите символ"
            } else {
                res.value = Gl(ch[0])
            }
        }) {
            Text("Проверить")
        }
        Text(text = res.value)
    }
}


fun Gl(ch: Char): String {
    return when {
        ch in listOf('a', 'e', 'u', 'i', 'o') -> "Это гласная буква"
        ch in listOf('y', 't', 'r', 'w', 'q', 'p', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z',
            'x', 'c', 'v', 'b', 'n', 'm') -> "Это согласная буква"
        else -> "Это не буква"
    }
}