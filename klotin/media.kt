fun main() {
    val media = readLine()?.toDouble()

    if (media != null) {
        val resultado = when {
            media < 5 -> "REP"
            media >= 5 && media < 7 -> "REC"
            media > 7 -> "APR"
            else -> "Média inválida"
        }

        println(resultado)
    } else {
        println("Entrada inválida. Insira um valor numérico.")
    }
}
