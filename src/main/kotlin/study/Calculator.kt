package study

class Calculator(
    val inputString: String
) {
    fun calculate(inputString: String): Double {
        validateAll(inputString)

        val parts = inputString.split(" ")
        var result = parts[0].toDouble();

        for (i in 1 until parts.size step 2) {
            val operator = parts[i]
            validateOperator(operator)

            val nextNumber = parts[i + 1].toDouble()

            result = operate(result, nextNumber, operator)
        }

        return result
    }

    /**
     * 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
     */
    fun validateAll(input: String?) {
        if (input == null || input.trim().isEmpty()) {
            throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
        }
    }

    /**
     * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
     */
    fun validateOperator(operator: String) {
        if (!operator.matches("[+\\-*/]".toRegex())) {
            throw IllegalArgumentException("주어진 문자열은 사칙연산 기호가 아닙니다.")
        }
    }

    /**
     * 주어진 숫자와 연산자로 사칙연산을 수행
     */
    fun operate(num1: Double, num2: Double, operator: String):Double {
        return when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> throw IllegalArgumentException("잘못된 연산자입니다.")
        }
    }
}