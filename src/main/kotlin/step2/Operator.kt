package step2

typealias CalculateStrategy = (leftValue: Operand, rightValue: Operand) -> Operand

enum class Operator(private val symbol: String, private val strategy: CalculateStrategy) {
    ADD("+", Operand::add),
    MINUS("-", Operand::minus),
    MULTIPLY("*", Operand::multiply),
    DIVIDE("/", Operand::divide);

    fun calculate(leftValue: Operand, rightValue: Operand): Operand {
        return strategy.invoke(leftValue, rightValue)
    }

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { operator -> operator.symbol == symbol }
                ?: throw IllegalArgumentException("$symbol 기호에 해당하는 연산은 존재하지 않습니다.")
        }
    }
}
