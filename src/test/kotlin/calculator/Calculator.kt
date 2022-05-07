package calculator

class Calculator {
    var total: Float = 0F

    fun calculate(calculatorFormula: String) {
        val parsedCalculateFormula = calculatorFormula.split(' ')

        total = parsedCalculateFormula[0].toFloat()
        val operand = parsedCalculateFormula[2].toFloat()

        when (parsedCalculateFormula[1]) {
            "+" -> total += operand
            "-" -> total -= operand
            "*" -> total *= operand
            "/" -> total /= operand
            else -> throw IllegalArgumentException("유효하지 않은 연산자 입니다.")
        }

        if (parsedCalculateFormula.size > 3) {
            val restParsedCalculateFormula = parsedCalculateFormula.drop(3)
            calculate("$total ${restParsedCalculateFormula.joinToString(" ")}")
        }
    }
}
