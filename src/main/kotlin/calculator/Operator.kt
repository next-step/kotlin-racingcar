package calculator

enum class Operator(private val operator: String) {
    PLUS("+") {
        override fun calculate(a: Int, b: Int) = a + b
    },
    MINUS("-") {
        override fun calculate(a: Int, b: Int) = a - b
    },
    TIMES("*") {
        override fun calculate(a: Int, b: Int) = a * b
    },
    DIV("/") {
        override fun calculate(a: Int, b: Int) = a / b
    },
    ;

    abstract fun calculate(a: Int, b: Int): Int

    companion object {
        fun from(operator: String): Operator? = values().find { it.operator == operator }
    }
}
