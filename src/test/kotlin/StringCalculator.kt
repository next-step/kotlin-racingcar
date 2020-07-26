object StringCalculator {
    fun calculate(value: String): Int {
        if (value.isBlank()) throw IllegalArgumentException("Empty value. Please input a expression. It must use like 1 + 2 * 3 / 4")
        val values = value.trim().split(" ")
        if (!isValid(values)) throw IllegalArgumentException("Invalid input. It must use like 1 + 2 * 3 / 4")
        var result = values.first().toInt()
        for (i in 1 until values.size step 2) {
            result = calculate(result, values[i], values[i + 1].toInt())
        }
        return result
    }

    private fun calculate(first: Int, operator: String, second: Int): Int {
        return when (operator) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            "/" -> first / second
            else -> throw IllegalArgumentException("Invalid operator")
        }
    }

    private fun isValid(values: List<String>): Boolean {
        if (values.size % 2 == 0) return false
        values.first().toDoubleOrNull() ?: return false
        values.last().toDoubleOrNull() ?: return false
        values.indexOf("/").let {
            if (it != -1) return values[it + 1].toInt() != 0
        }
        return true
    }
}
