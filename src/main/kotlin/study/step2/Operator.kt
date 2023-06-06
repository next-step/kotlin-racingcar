package study.step2

class Operator private constructor (val value: String) {
    companion object {
        fun of(value: String): Operator {
            if (!listOf("+", "-", "*", "/").contains(value)) {
                throw IllegalArgumentException()
            }
            return Operator(value)
        }
    }
    fun apply(left: Operand, right: Operand): Int {
        return when (value) {
            "+" -> left.value + right.value
            "-" -> left.value - right.value
            "*" -> left.value * right.value
            "/" -> left.value / right.value
            else -> throw IllegalStateException()
        }
    }
}
