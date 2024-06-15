package com.example.evaluacion1

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto * 0.80 // Retención del 20%
    }
}
