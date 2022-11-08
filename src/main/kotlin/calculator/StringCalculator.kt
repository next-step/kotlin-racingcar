package calculator

class StringCalculator {

    fun calculate(input: String): Num {

        val data = removeSpace(input)
        verifyOperator(data)

        val expression = Expression(data)
        val queue = expression.apply()

        var result = Num(queue.poll())

        while (queue.isNotEmpty()) {
            val operator = queue.poll()
            val operand = queue.poll()
            val o = Operator(operator.first())
            result = o.calculate(result, Num(operand))
        }

        return result
    }

    private fun removeSpace(input: String): String {
        return input.replace(" ", "")
    }

    private fun verifyOperator(data: String) {
        val splitData = data.split("+", "-", "*", "/")

        if (splitData.size != data.length - (data.length / 2)) {
            throw IllegalArgumentException()
        }

        for (c in splitData) {
            try {
                Integer.parseInt(c)
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException()
            }
        }
    }
}
