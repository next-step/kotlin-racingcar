class Calculator {
    fun execute(input: String?): Int {
        require(!input.isNullOrBlank()) { "Input must have a value" }

        val formula: List<String> = input.split(" ").toList()

        var res = formula.get(0).toInt()
        for (i in 1 until formula.size step 2) {
            val operator: String = formula.get(i)
            val b = formula.get(i + 1).toInt()
            res = calculate(res, b, operator)
        }
        return res
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
