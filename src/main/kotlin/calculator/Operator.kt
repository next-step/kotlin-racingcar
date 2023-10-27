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
        override fun calculate(a: Int, b: Int): Int {
            require(b != 0) { "0으로 나눌 수 없습니다." }
            return a / b
        }
    },
    ;

    abstract fun calculate(a: Int, b: Int): Int

    companion object {
        fun from(operator: String): Operator =
            values().find { it.operator == operator } ?: throw IllegalArgumentException("입력 값에 사칙 연산이 아닌 기호가 포함되었습니다.")
    }
}
