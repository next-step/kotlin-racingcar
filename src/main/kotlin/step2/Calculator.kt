package step2

class Calculator {
    fun calculate(input: String?): Double {
        Validator.validateInput(input)

        val parts = input!!.split(" ")
        var result = parts[0].toDouble();

        for (i in 1 until parts.size step 2) {
            val operator = parts[i]
            Validator.validateOperator(operator)

            val nextNumber = parts[i + 1].toDouble()

            result = operate(result, nextNumber, operator)
        }

        return result
    }

    /**
     * 주어진 숫자와 연산자로 사칙연산을 수행
     */
    fun operate(num1: Double, num2: Double, operator: String): Double {
        return when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> throw IllegalArgumentException("잘못된 연산자입니다.")
        }
    }
}