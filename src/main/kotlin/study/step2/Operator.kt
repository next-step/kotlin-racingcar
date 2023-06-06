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
    fun apply(left: Int, right: Int): Int {
        return when (value) {
            "+" -> left + right
            "-" -> left - right
            "*" -> left * right
            "/" -> left / right
            else -> throw IllegalStateException()
        }
    }
}
