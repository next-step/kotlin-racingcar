package caculator

class Calculator {

    fun calculate(text: String): Double {
        val tokens = text.split(" ")
        var operand1: Double = tokens[0].toDouble()

        (1 until tokens.size - 1 step 2).forEach { i ->
            var operand2: Double = tokens[i + 1].toDouble()
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
