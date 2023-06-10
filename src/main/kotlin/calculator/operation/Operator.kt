package calculator.operation

enum class Operator(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIV("/");

    companion object {
        fun getOperator(input: String, leftOperation: InfixOperation, rightOperation: InfixOperation) =
            when (input) {
                PLUS.symbol -> PlusOperation(leftOperation, rightOperation)
                MINUS.symbol -> MinusOperation(leftOperation, rightOperation)
                TIMES.symbol -> MultiplyOperation(leftOperation, rightOperation)
                DIV.symbol -> DivideOperation(leftOperation, rightOperation)
                else -> throw IllegalArgumentException("지원 하지 않는 연산자입니다.")
            }
    }
}
