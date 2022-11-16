package calculator

class StringCalculator {
    fun calculate(text: String): Int {
        val (operands, operators) = parse(text)

        var result: Int = operands[0]
        for (i in 0..operands.size - 2) {
            val operator = Operator.find(operators[i])
            result = operator.operate(result, operands[i + 1])
        }

        return result
    }

    private fun parse(text: String): Pair<List<Int>, List<Char>> {
        val operands = mutableListOf<Int>()
        val operators = mutableListOf<Char>()

        val tokens = text.split(" ")

        tokens.forEach { token ->
            if (isInt(token)) operands.add(token.toInt())
            else operators.add(token.first())
        }

        return operands to operators
    }

    private fun isInt(s: String): Boolean {
        return s.toIntOrNull() != null
    }
}
