package calculator

class Calculator {
    var total: Float = 0F

    fun calculate(calculatorFormula: String) {
        val parsedCalculateFormula = calculatorFormula.split(' ')

        total = parsedCalculateFormula[0].toFloat()
        val operand = parsedCalculateFormula[2].toFloat()

        when (parsedCalculateFormula[1]) {
            "+" -> this.total += operand
            "-" -> this.total -= operand
            "*" -> this.total *= operand
            "/" -> this.total /= operand
        }

        if (parsedCalculateFormula.size > 3) {
            val restParsedCalculateFormula = parsedCalculateFormula.drop(3)
            calculate("$total ${restParsedCalculateFormula.joinToString(" ")}")
        }
    }
}
