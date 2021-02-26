package caculator

class Calculator {

    fun calculate(text: String): Number {
        val tokens = text.split(" ")
        var operand1 = Number(tokens[0])

        (1 until tokens.size - 1 step 2).forEach { i ->
            var operand2 = Number(tokens[i + 1])
            val operator = tokens[i]

            when (operator) {
                "+" -> operand1 += operand2
                "-" -> operand1 -= operand2
                "*" -> operand1 *= operand2
                "/" -> operand1 /= operand2
            }
        }
        return operand1
    }
}
