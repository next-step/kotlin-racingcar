package step2

enum class Operator(
    val arithmeticSymbol: String,
    val operation: (Double, Double) -> Double,
) {

    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVISION("/", { a, b -> a / b });

    companion object {
        private val map = values()
            .associateBy(Operator::arithmeticSymbol)

        @JvmStatic
        fun findBy(arithmeticSymbol: String): Operator {
            return map[arithmeticSymbol] ?: throw NotSupportOperationException("지원하지 않는 operation 입니다. $arithmeticSymbol")
        }
    }
}
