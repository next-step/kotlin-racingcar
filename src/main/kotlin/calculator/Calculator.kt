package calculator

object Calculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("Invalid expression")

        val listOfNumOrOperands = expression.split(" ")

        return parseNumber(listOfNumOrOperands)
    }

    private fun parseNumber(list: List<String>, operator: Operator = Operator.PLUS, result: Int = 0): Int = when (list.isEmpty()) {
        true -> throw IllegalArgumentException("Invalid expression")
        false -> parseOperand(list.drop(1), operator.calculate(result, list[0].toInt()))
    }

    private fun parseOperand(list: List<String>, result: Int): Int = when (list.isEmpty()) {
        true -> result
        false -> parseNumber(list.drop(1), Operator.get(list[0]), result)
    }

    private fun String.toInt(): Int = this.toIntOrNull() ?: throw IllegalArgumentException("Invalid number: $this")
}
