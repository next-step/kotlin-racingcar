package string_calculator

class CalculatorService {
    companion object {
        private const val FIRST_OPERATOR = '+'
        private const val ZERO = 0
    }

    fun verifyExpression(expression: String?) {
        if (expression.isNullOrBlank())
            throw IllegalArgumentException("입력 값이 올바르지 않습니다.")
    }

    fun calculator(list: List<String>): Int {
        var operator = FIRST_OPERATOR
        var result = ZERO

        list.forEachIndexed { index, s ->
            if (index % 2 != 0) {
                verifyOperator(s)
                operator = s.first()
                return@forEachIndexed
            }

            val num2 = verifyNumber(s)
            if (operator == Calculation.DIVIDE.operator && num2 == 0)
                throw ArithmeticException("0 으로 나눌 수 없습니다.")
            result = Calculation.calculate(result, num2, operator)
        }
        return result
    }

    private fun verifyOperator(s: String) {
        if (s.length != 1 || !Calculation.isValid(s.first()))
            throw IllegalArgumentException("잘못된 연산자 입니다.")
    }

    private fun verifyNumber(s: String): Int {
        if (!s.all { Character.isDigit(it) })
            throw IllegalArgumentException("피연산자는 자연수여야 합니다.")
        try {
            return s.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자로 컨버팅 할 수 없습니다.")
        }
    }
}
