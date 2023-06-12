package calculator.operation

enum class Operator(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIV("/");

    companion object {
        private val OPERATOR_SYMBOLS = Operator.values().map { it.symbol }.toSet()

        fun isOperator(value: String): Boolean = OPERATOR_SYMBOLS.contains(value)

        fun splitOperators(expression: String): List<String> {
            return expression.filter { it.toString() in OPERATOR_SYMBOLS }.map { it.toString() }
        }

        fun splitOperands(expression: String): List<String> {
            return expression.split(*OPERATOR_SYMBOLS.toTypedArray()).filter { it.isNotBlank() }
        }

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
