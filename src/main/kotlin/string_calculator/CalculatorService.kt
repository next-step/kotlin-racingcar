package string_calculator

class CalculatorService {
    fun verifyExpression(expression: String?) {
        require(!expression.isNullOrBlank()) { "입력 값이 올바르지 않습니다." }
    }

    fun calculator(list: List<String>): Int {
        var operator = FIRST_OPERATOR
        var result = ZERO

        list.forEachIndexed { index, s ->
            val turnToOperand = index % TWO != ZERO
            if (turnToOperand) {
                verifyOperator(s)
                operator = s.first()
                return@forEachIndexed
            }

            val num2 = verifyNumber(s)
            result = Calculation.calculate(result, num2, operator)
        }
        return result
    }

    private fun verifyOperator(s: String) {
        require(s.length == ONE && Calculation.isValid(s.first())) { "잘못된 연산자 입니다." }
    }

    private fun verifyNumber(s: String): Int {
        require(s.all { Character.isDigit(it) }) { "피연산자는 자연수여야 합니다." }
        try {
            return s.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자로 컨버팅 할 수 없습니다.")
        }
    }

    companion object {
        private const val FIRST_OPERATOR = '+'
        private const val ZERO = 0
        private const val ONE = 1
        private const val TWO = 2
    }
}
