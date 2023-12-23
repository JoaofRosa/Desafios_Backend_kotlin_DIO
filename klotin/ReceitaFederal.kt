object ReceitaFederal {
    fun calcularImposto(salario: Double): Double {
        return when {
            salario <= 1100.00 -> salario * 0.05
            salario <= 2500.00 -> salario * 0.10
            else -> salario * 0.15
        }
    }
}

fun main() {
    val valorSalario = readLine()!!.toDouble()

    val valorBeneficios = readLine()!!.toDouble()

    val valorImposto = ReceitaFederal.calcularImposto(valorSalario)
    val salarioTransferido = (valorSalario - valorImposto) + valorBeneficios

    println(String.format("%.2f", salarioTransferido))
}
