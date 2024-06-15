package com.example.evaluacion1

// Importaciones necesarias para la actividad principal y la UI en Compose
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evaluacion1.ui.theme.CalculoContratoActivity
import com.example.evaluacion1.ui.theme.CalculoHonorariosScreen

// Clase principal de la actividad que extiende ComponentActivity
class MainActivity : ComponentActivity() {
    // Método onCreate que se llama cuando la actividad es creada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad usando Jetpack Compose
        setContent {
            MainScreen()
        }
    }
}

// Función composable que define la pantalla principal
@Composable
fun MainScreen() {
    // Recordar el controlador de navegación
    val navController = rememberNavController()

    // Define el host de navegación y las rutas
    NavHost(navController, startDestination = "main") {
        // Ruta para el menú principal
        composable("main") { MainMenu(navController) }
        // Ruta para la pantalla de cálculo de honorarios
        composable("honorarios") { CalculoHonorariosScreen(navController) }
    }
}

// Función composable que define el menú principal
@Composable
fun MainMenu(navController: NavController) {
    // Obtener el contexto actual
    val context = LocalContext.current

    // Definir una columna para alinear los botones
    Column(
        modifier = Modifier
            .fillMaxSize() // La columna ocupa todo el tamaño de la pantalla
            .padding(16.dp), // Añade padding alrededor de la columna
        verticalArrangement = Arrangement.Center, // Alinear verticalmente al centro
        horizontalAlignment = Alignment.CenterHorizontally // Alinear horizontalmente al centro
    ) {
        // Botón para calcular contrato
        Button(
            onClick = {
                // Inicia la actividad de cálculo de contrato
                context.startActivity(Intent(context, CalculoContratoActivity::class.java))
            },
            modifier = Modifier.padding(8.dp) // Añade padding alrededor del botón
        ) {
            Text("Calcular Contrato") // Texto del botón
        }

        // Botón para calcular honorarios
        Button(
            onClick = {
                // Navega a la pantalla de cálculo de honorarios usando el controlador de navegación
                navController.navigate("honorarios")
            },
            modifier = Modifier.padding(8.dp) // Añade padding alrededor del botón
        ) {
            Text("Calcular Honorarios") // Texto del botón
        }
    }
}
