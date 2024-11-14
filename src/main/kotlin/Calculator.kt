class Calculator {
    fun execute(input: String?): Int {
        require(!input.isNullOrBlank()) { "Input must have a value" }

        val formula: List<String> = input.split(" ").toList()

        return formula.drop(1).chunked(2).fold(formula.first().toInt()) { acc, (operator, value) ->
            calculate(acc, value.toInt(), operator)
        }
    }

    private fun calculate(
        a: Int,
        b: Int,
        operator: String,
    ): Int {
        return when (operator) {
            "+" -> sum(a, b)
            "-" -> subtract(a, b)
            "*" -> multiply(a, b)
            "/" -> divide(a, b)
            else -> throw IllegalArgumentException("Invalid Operator.")
        }
    }

    private fun sum(
        a: Int,
        b: Int,
    ): Int = a + b

    private fun subtract(
        a: Int,
        b: Int,
    ): Int = a - b

    private fun multiply(
        a: Int,
        b: Int,
    ): Int = a * b

    private fun divide(
        a: Int,
        b: Int,
    ): Int = a / b
}
