package com.example.evaluacion1.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.evaluacion1.EmpleadoHonorarios

// Función composable para la pantalla de cálculo de honorarios
@Composable
fun CalculoHonorariosScreen(navController: NavController) {
    // Variable de estado para el ingreso del sueldo bruto por el usuario
    var sueldoBruto by remember { mutableStateOf("") }
    // Variable de estado para el resultado del cálculo
    var resultado by remember { mutableStateOf("") }

    // Contenedor de diseño para organizar los elementos en una columna
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio disponible
            .padding(16.dp), // Margen alrededor de la columna
        verticalArrangement = Arrangement.Center, // Centra el contenido verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente
    ) {
        // Elemento de texto para el título de la pantalla
        Text("Cálculo de Honorarios")

        // Campo de texto para el ingreso del sueldo bruto por el usuario
        OutlinedTextField(
            value = sueldoBruto, // Valor actual del campo de texto
            onValueChange = { sueldoBruto = it }, // Actualiza la variable de estado cuando cambia el valor
            label = { Text("Sueldo Bruto") }, // Etiqueta del campo de texto
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number) // Opciones del teclado para entrada numérica
        )

        // Botón para iniciar el cálculo
        Button(onClick = {
            val sueldo = sueldoBruto.toDoubleOrNull() // Convierte el valor ingresado a double
            if (sueldo != null) { // Si la entrada es un número válido
                val empleado = EmpleadoHonorarios(sueldo) // Crea una instancia de EmpleadoHonorarios
                resultado = "Pago líquido: ${empleado.calcularLiquido()}" // Calcula y muestra el pago líquido
            } else {
                resultado = "Ingrese un sueldo válido" // Muestra un mensaje de error si la entrada es inválida
            }
        }) {
            // Texto dentro del botón
            Text("Calcular")
        }

        // Elemento de texto para mostrar el resultado del cálculo o un mensaje de error
        Text(resultado)

        // Espaciador para agregar espacio entre los elementos
        Spacer(modifier = Modifier.height(16.dp))

        // Botón para navegar de vuelta a la pantalla principal
        Button(onClick = { navController.navigate("main") }) {
            // Texto dentro del botón
            Text("Volver")
        }
    }
}

// Función de vista previa para mostrar la pantalla en el entorno de desarrollo
@Preview(showBackground = true)
@Composable
fun PreviewCalculoHonorariosScreen() {
    CalculoHonorariosScreen(navController = rememberNavController()) // Usando un NavController ficticio para la vista previa
}

