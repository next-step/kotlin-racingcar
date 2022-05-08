package calculator

// 관심사 분리
// calculator - 계산된 결괏값을 반환
// operator - operator 에 따른 계산

class Calculator {
    private var total: Float = 0F

    fun calculate(calculatorFormula: String?): Float {
        if (calculatorFormula.isNullOrEmpty()) {
            throw IllegalArgumentException("유효하지 않은 계산식 입니다.")
        }

        val parsedCalculateFormula = this.parsedFor(calculatorFormula)

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

        return total
    }

    private val parsedFor = {
        calculatorFormula: String ->
        calculatorFormula.split(' ')
    }
}
