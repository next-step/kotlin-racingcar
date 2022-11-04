package calculator

/**
 * 계산 연산자
 */
enum class Operator(val symbol: String) {

    PLUS("+") {
        override fun operate(a: Int, b: Int): Int = a + b
    },
    MINUS("-") {
        override fun operate(a: Int, b: Int): Int = a - b
    },
    MULTIPLY("*") {
        override fun operate(a: Int, b: Int): Int = a * b
    },
    DIVIDE("/") {
        override fun operate(a: Int, b: Int): Int {
            require(b != 0) { "0으로 나눌 수 없습니다." }
            return a / b
        }
    };

    abstract fun operate(a: Int, b: Int): Int

    companion object {
        fun of(symbol: String): Operator {
            values().forEach {
                if (it.symbol == symbol) return it
            }
            throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
