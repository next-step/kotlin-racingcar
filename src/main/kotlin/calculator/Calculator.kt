package calculator

class Calculator {
    fun calculate(expression: String): Int {
        val elements = expression.split(" ").groupBy { isNumeric(it) }
        val numbers = elements[true]?.map { it.toInt() }
        val operators = elements[false]!!

        if (numbers.isNullOrEmpty()) {
            return 0
        }

        return numbers.reduceIndexed { index, total, number ->
            calculate(total, number, operators[index - 1])
        }
    }

    private fun calculate(num1: Int, num2: Int, display: String): Int {
        return Operator.find(display).evaluate(num1, num2)
    }
}
