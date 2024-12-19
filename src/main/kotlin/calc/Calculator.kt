package calc

class Calculator(
    private val input: String
) {
    init {
        require(
            input.split(" ").withIndex()
                .all { (idx, value) ->
                    if (idx % 2 == 0) value.isNumber() else value.isOperator()
                }
        ) { "형식 지켜랴 ㅋ" }
    }

    fun calc(): Int {
        val elements = input.split(" ")
            .filterNot { it.isBlank() }
            .groupBy { it.isNumber() }

        val expressions = elements[false] ?: emptyList()
        val numbers = (elements[true] ?: emptyList())
            .map { it.toInt() }
            .toCollection(ArrayDeque())

        for (expr in expressions) {
            val operand1 = numbers.removeFirst()
            val operand2 = numbers.removeFirst()

            val result = when (expr) {
                "+" -> operand1 + operand2
                "-" -> operand1 - operand2
                "*" -> operand1 * operand2
                "/" -> operand1 / operand2
                else -> throw IllegalArgumentException()
            }

            numbers.addFirst(result)
        }

        return numbers.last()
    }
}

private fun String.isNumber() = toIntOrNull() != null
private fun String.isOperator() = this in setOf("+", "-", "*", "/")
