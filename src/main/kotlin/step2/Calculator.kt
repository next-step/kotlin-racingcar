package step2

object Calculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("Invalid expression")

        val listOfNumOrOperands = expression.split(" ")

        return parseNumber(listOfNumOrOperands)
    }

    private fun parseNumber(list: List<String>, op: Operation = AdditionWithN1(0)): Int = when (list.isEmpty()) {
        true -> throw IllegalArgumentException("Invalid expression")
        false -> parseOperand(list.drop(1), op.calc(toInt(list[0])))
    }

    private fun parseOperand(list: List<String>, acc: Int = 0): Int = when (list.isEmpty()) {
        true -> acc
        false -> parseNumber(list.drop(1), Operation.get(list[0])(acc))
    }

    private fun toInt(n: String): Int = n.toIntOrNull() ?: throw IllegalArgumentException("Invalid number: $n")
}
