package calculator

enum class Operator(val value: String, val operate: (Int, Int) -> Int) {
    ADDITION("+", { param1, param2 -> param1 + param2 }),
    SUBTRACTION("-", { param1, param2 -> param1 - param2 }),
    MULTIPLICATION("*", { param1, param2 -> param1 * param2 }),
    DIVISION("/", { param1, param2 -> param1 / param2 });

    companion object {
        fun toOperator(value: String): Operator = entries.find {
            it.value == value
        } ?: throw IllegalArgumentException("Unsupported Operator")
    }
}
