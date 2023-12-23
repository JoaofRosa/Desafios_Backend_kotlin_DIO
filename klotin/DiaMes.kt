fun main() {
    val entrada = readLine()
    
    if (entrada != null && entrada.matches(Regex("\\d{2}/\\d{2}/\\d{4}"))) {
        val partes = entrada.split("/")
        val dia = partes[0].toInt()
        val mes = partes[1].toInt()
        val ano = partes[2].toInt()

        val nomeMes = obterNomeMes(mes)
        val diaF = String.format("%02d", dia)

        println("$diaF de $nomeMes de $ano")
    } else {
        println("Formato de data inválido. Use o formato DD/MM/YYYY.")
    }
}

fun obterNomeMes(mes: Int): String {
    return when (mes) {
        1 -> "Janeiro"
        2 -> "Fevereiro"
        3 -> "Marco"
        4 -> "Abril"
        5 -> "Maio"
        6 -> "Junho"
        7 -> "Julho"
        8 -> "Agosto"
        9 -> "Setembro"
        10 -> "Outubro"
        11 -> "Novembro"
        12 -> "Dezembro"
        else -> "Mês inválido"
    }
}