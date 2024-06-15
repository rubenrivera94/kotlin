package com.example.evaluacion1.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion1.EmpleadoRegular
import com.example.evaluacion1.R
import com.example.evaluacion1.databinding.ActivityCalculoContratoBinding

// Definición de la clase CalculoContratoActivity que extiende AppCompatActivity
class CalculoContratoActivity : AppCompatActivity() {
    // Declaración de una propiedad lateinit para el binding de la actividad
    private lateinit var binding: ActivityCalculoContratoBinding
    // Método onCreate, llamado cuando la actividad es creada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar el layout usando View Binding y asignarlo a la propiedad binding
        binding = ActivityCalculoContratoBinding.inflate(layoutInflater)
        // Establecer la vista de contenido de la actividad con la raíz del binding
        setContentView(binding.root)
        // Configurar un OnClickListener para el botón de calcular
        binding.buttonCalcular.setOnClickListener {
            // Obtener el valor ingresado en el campo de texto del sueldo bruto y convertirlo a Double
            val sueldoBruto = binding.editTextSueldoBruto.text.toString().toDoubleOrNull()
            // Verificar si el sueldo bruto es un número válido
            if (sueldoBruto != null) {
                // Crear una instancia de EmpleadoRegular con el sueldo bruto
                val empleado = EmpleadoRegular(sueldoBruto)
                // Calcular el pago líquido y formatear el resultado en un string
                val resultado = getString(R.string.resultado_pago_liquido, empleado.calcularLiquido())
                // Mostrar el resultado en el TextView
                binding.textViewResultado.text = resultado
            } else {
                // Si el sueldo bruto no es válido, mostrar un mensaje de error
                binding.textViewResultado.text = getString(R.string.mensaje_sueldo_invalido)
            }
        }
        // Configurar un OnClickListener para el botón de volver
        binding.buttonVolver.setOnClickListener {
            // Finalizar la actividad y volver a la pantalla anterior
            finish()
        }
    }
}

