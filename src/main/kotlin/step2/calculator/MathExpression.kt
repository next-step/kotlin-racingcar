package step2.calculator

private const val REQUIRED_OPERATOR_MIN_SIZE = 1
private const val REQUIRED_OPERAND_MIN_SIZE = 2
private const val IS_ONE_SMALLER_THAN_OPERAND_SIZE = 1

data class MathExpression(
    private val _operands: List<Operand>,
    private val _operators: List<Operator>
) {
    init {
        require(
            assertOperandSizeAndOperatorSizeIsValidSize()
        )
    }

    private fun assertOperandSizeAndOperatorSizeIsValidSize() =
        _operands.size >= REQUIRED_OPERAND_MIN_SIZE &&
            _operators.size >= REQUIRED_OPERATOR_MIN_SIZE &&
            _operands.size == _operators.size + IS_ONE_SMALLER_THAN_OPERAND_SIZE

    val operands: List<Operand>
        get() = _operands.toList()
    val operators: List<Operator>
        get() = _operators.toList()

    val operatorsSize: Int
        get() = _operators.size
}
