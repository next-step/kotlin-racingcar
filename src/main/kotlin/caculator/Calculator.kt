package caculator

class Calculator(private val delimiter: String = " ") {
    fun calculate(text: String): Number {
        require(text.isNotBlank()) { "text must be not empty" }

        val tokens = text.split(this.delimiter)
        var operand1 = Number(tokens[0])

        (1 until tokens.size - 1 step 2).forEach { i ->
            val operand2 = Number(tokens[i + 1])
            val operator = Operator.find(tokens[i])

            operand1 = operator?.operate(operand1, operand2)
                ?: throw IllegalArgumentException("invalid operator token ${tokens[i]}")
        }
        return operand1
    }
}
