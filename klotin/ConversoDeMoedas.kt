// Antiga classe de conversão que só suporta a conversão de USD para GBP
class OldCurrencyConverter {
    fun convertUSDtoGBP(amount: Double): Double {
        return amount * 0.80 // 80% do valor em USD
    }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR
class CurrencyAdapter(private val oldConverter: OldCurrencyConverter, private val gbpToEurRate: Double) {
    fun convertUSDtoEUR(amount: Double): Double {
        val amountInGBP = oldConverter.convertUSDtoGBP(amount)
        val amountInEUR = amountInGBP * gbpToEurRate
        return amountInEUR
    }
}

fun main() {
    val input = readLine()?.toDoubleOrNull() ?: return
    val oldConverter = OldCurrencyConverter()

    // Defina a taxa de conversão de GBP para EUR conforme o enunciado
    val gbpToEurRate = 1.0625 

    val adapter = CurrencyAdapter(oldConverter, gbpToEurRate)

    val amountInEUR = adapter.convertUSDtoEUR(input)

    println("USD: $input")
    println("EUR: $amountInEUR")
}
