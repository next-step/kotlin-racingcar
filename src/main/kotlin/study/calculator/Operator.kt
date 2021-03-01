package study.calculator

enum class Operator(
    val symbol: String
) {
    PLUS("+") { override fun calculate(preNum: Int, nextNum: Int) = preNum + nextNum },
    MINUS("-") { override fun calculate(preNum: Int, nextNum: Int) = preNum - nextNum },
    MULTIPLY("*") { override fun calculate(preNum: Int, nextNum: Int) = preNum * nextNum },
    DIVIDE("/") {
        override fun calculate(preNum: Int, nextNum: Int): Int {
            if (nextNum == INVALID_DIVISOR_ZERO) {
                throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            }
            return preNum / nextNum
        }
    };

    abstract fun calculate(preNum: Int, nextNum: Int): Int

    companion object {

        private const val INVALID_DIVISOR_ZERO = 0

        fun findBySymbol(symbol: String): Operator? {
            return values().find { it.symbol == symbol }
        }
    }
}
