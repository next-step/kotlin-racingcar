package calculator.operationtoken

class Operand(val value: Int) : OperationToken {

    companion object {
        fun of(value: Int) = Operand(value)
    }
}
