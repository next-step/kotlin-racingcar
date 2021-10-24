package step2.calculator

private const val OPERATOR_MIN_SIZE = 1
private const val OPERAND_MIN_SIZE = 2

data class MathExpression(
    private val _operands: List<Operand>,
    private val _operators: List<Operator>
) {
    init {
        require(
            _operands.size >= OPERAND_MIN_SIZE &&
                _operators.size >= OPERATOR_MIN_SIZE &&
                _operands.size == _operators.size + 1
        )
    }

    val operands: List<Operand>
        get() = _operands.toList()
    val operators: List<Operator>
        get() = _operators.toList()

    // val operandsSize: Int
    //     get() = _operands.size
    val operatorsSize: Int
        get() = _operators.size
}
