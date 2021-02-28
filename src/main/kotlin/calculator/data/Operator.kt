package calculator.data

import calculator.util.Const.Companion.NOTICE_NOT_OPERATOR_SYMBOL

@Suppress("unused")
enum class Operator(
    private val operatorSymbol: String,
    private val calculateStrategy: (leftValue: Operand, rightValue: Operand) -> Operand
) {
    ADD("+", Operand::add),
    MINUS("-", Operand::minus),
    MULTIPLY("*", Operand::multiply),
    DIVIDE("/", Operand::divide);

    fun calculate(leftValue: Operand, rightValue: Operand): Operand {
        return calculateStrategy.invoke(leftValue, rightValue)
    }

    companion object {
        fun findByOperatorSymbol(operatorSymbol: String): Operator {
            return requireNotNull(
                values().find { operator ->
                    operator.operatorSymbol == operatorSymbol
                },
                { operatorSymbol.plus(NOTICE_NOT_OPERATOR_SYMBOL) }
            )
        }
    }
}
