package step2

class Calculator {
    private var total = 0

    fun calculate(expression: String): Int {
        val elements = expression.split(" ").groupBy { isNumeric(it) }
        val numbers = elements[true]?.map { it.toInt() }
        val operators = elements[false]!!

        if (numbers.isNullOrEmpty()) {
            return 0
        }

        this.total = numbers[0]

        for ((i, v) in numbers.drop(1).withIndex()) {
            this.total = calculate(this.total, v, operators[i])
        }

        return this.total
    }

    private fun calculate(num1: Int, num2: Int, display: String): Int {
        return Operator.find(display).evaluate(num1, num2)
    }
}
