package calculator

enum class Operator(private val operator: String) {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    companion object {
        @Throws(IllegalArgumentException::class)
        fun valueOfString(operator: String): Operator {
            return try {
                Operator.values().first { it.operator == operator }
            } catch (e: NoSuchElementException) {
                throw IllegalArgumentException("Invalid operator: $operator")
            }
        }
    }

    fun execute(a: Double, b: Double): Double = when (this) {
        ADD -> a + b
        SUB -> a - b
        MUL -> a * b
        DIV -> a / b
    }
}
