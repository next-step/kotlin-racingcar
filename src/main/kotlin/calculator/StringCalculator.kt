package calculator

class StringCalculator {

    fun calculate(input: String): Int {

        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException()
        }

        var data = input.replace(" ", "")
        verifyOperator(data)

        val expression = Expression(data)
        val queue = expression.apply()

        var result: Int = Integer.parseInt(queue.poll())

        if (queue.size % 2 != 0) {
            throw IllegalStateException()
        }

        while (!queue.isEmpty()) {
            val operator = queue.poll()
            val operand = queue.poll()

            val o = Operator(operator.first())
            result = o.calculate(result, Integer.parseInt(operand))
        }

        return result
    }

    private fun verifyOperator(data: String) {
        // 2 * 3 + 1 - 1 = 7 중 피연산자 4, 연사자 3, 연사자로 스플릿한다면 피연산자는 4개나와야함
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
