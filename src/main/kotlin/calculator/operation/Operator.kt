package calculator.operation

enum class Operator(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIV("/");

    companion object {
        val OPERATOR_REGEX = "[+\\-*/]".toRegex()
        val OPERAND_REGEX = "\\d".toRegex()
        val OPERATOR_AND_OPERAND_REGEX = "[\\d+\\-*/]+".toRegex()

        fun splitOperators(expression: String): List<String> =
            expression
                .replace(OPERAND_REGEX, "")
                .asSequence()
                .map { it.toString() }
                .toList()

        fun splitOperands(expression: String): List<String> =
            expression
                .split(OPERATOR_REGEX)
                .asSequence()
                .filter { it.isNotBlank() }
                .toList()

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
