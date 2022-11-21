package calculator

class StringCalculator {

    fun calculate(mathematical: String): Num {

        val expression = Expression(mathematical)
        val queue = expression.compute()

        var result = Num(queue.poll())

        while (queue.isNotEmpty()) {
            val operator = Operator(queue.poll().first())
            val second = Num(queue.poll())
            result = calculate(result, second, operator)
        }

        return result
    }

    private fun calculate(first: Num, second: Num, operator: Operator) = operator.calculate(first, second)
}
