package calculator

enum class Operator(private val operator: String) {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    companion object {
        fun valueOfString(operator: String): Operator {
            return when (operator) {
                ADD.operator -> ADD
                SUB.operator -> SUB
                MUL.operator -> MUL
                DIV.operator -> DIV
                else -> throw IllegalArgumentException("Invalid operator: $operator")
            }
        }
    }

    fun execute(a: Int, b: Int): Int = when (this) {
        ADD -> a + b
        SUB -> a - b
        MUL -> a * b
        DIV -> a / b
    }
}
