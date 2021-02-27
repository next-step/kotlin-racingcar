package study.calculator

enum class Operator(
    val symbol: String
) {
    PLUS("+") { override fun calculate(preNum: Int, nextNum: Int) = preNum + nextNum },
    MINUS("-") { override fun calculate(preNum: Int, nextNum: Int) = preNum - nextNum },
    MULTIPLY("*") { override fun calculate(preNum: Int, nextNum: Int) = preNum * nextNum },
    DIVIDE("/") {
        override fun calculate(preNum: Int, nextNum: Int): Int {
            if (nextNum == 0) {
                throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            }
            return preNum / nextNum
        }
    };

    abstract fun calculate(preNum: Int, nextNum: Int): Int

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException("${symbol}는 존재하지 않는 연산자입니다.")
        }
    }
}
