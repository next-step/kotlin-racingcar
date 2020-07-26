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

    private fun calculate(first: Int, sign: String, second: Int): Int {
        return Operator(sign).operation(first, second)
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

enum class Operator(val sign: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        operator fun invoke(sign: String): Operator {
            return values().find { it.sign == sign }
                ?: throw IllegalArgumentException("Invalid Operator")
        }
    }
}
