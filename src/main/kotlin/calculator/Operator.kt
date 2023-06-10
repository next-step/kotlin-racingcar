package calculator

enum class Operator(private val symbol: String) {

    PLUS("+") {
        override fun calculate(input1: Int, input2: Int): Int = input1 + input2
    },
    MINUS("-") {
        override fun calculate(input1: Int, input2: Int) = input1 - input2
    },
    MULTIPLY("*") {
        override fun calculate(input1: Int, input2: Int) = input1 * input2
    },
    DIVISION("/") {
        override fun calculate(input1: Int, input2: Int): Int {
            require(input2 != 0) { "0으로 나눌 수 없습니다." }
            return input1 / input2
        }
    };

    private fun satisfy(input: String) = input == symbol
    abstract fun calculate(input1: Int, input2: Int): Int

    companion object {
        fun of(input: String): Operator? {
            return Operator.values().find { it.satisfy(input) }
        }
    }
}
