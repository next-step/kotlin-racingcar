package calculator.operationtoken

class Operand(val value: Int) : OperationToken {
    override val isOperator: Boolean = false

    companion object {
        fun of(value: Int) = Operand(value)
    }
}
