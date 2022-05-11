package calculator

class Calculator {
    fun calculate(expression: String?): Int {
        validate(expression)

        val elements = expression!!.split(" ").groupBy { isNumeric(it) }
        val numbers = elements[true]?.map { it.toInt() }
        val operators = elements[false]

        if (numbers.isNullOrEmpty()) {
            return 0
        }

        if (operators.isNullOrEmpty()) {
            return numbers[0]
        }

        return numbers.reduceIndexed { index, total, number ->
            calculate(total, number, operators[index - 1])
        }
    }

    private fun validate(expression: String?) {
        if (expression.isNullOrEmpty()) {
            throw IllegalArgumentException("빈문자열은 입력될 수 없습니다.")
        }
    }

    private fun calculate(num1: Int, num2: Int, symbol: String): Int {
        return Operator.find(symbol).evaluate(num1, num2)
    }
}
