package com.example.hola

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SaludoScreen()
                }
            }
        }
    }
}

@Composable
fun SaludoScreen() {
    // Estado del texto que escribe el usuario
    var nombre by remember { mutableStateOf("") }
    // Estado del saludo que se muestra
    var saludo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Campo de entrada de texto (EditText)
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Escribe tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        // Espacio
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(8.dp))

        // Botón
        Button(
            onClick = {
                saludo = if (nombre.isNotBlank()) {
                    "¡Hola, $nombre! Bienvenido/a 👋"
                } else {
                    "Por favor escribe tu nombre"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Saludar")
        }

        // Espacio
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(8.dp))

        // Etiqueta de texto (TextView) que muestra el saludo dinámico
        Text(
            text = saludo,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}