package calculator.operation

import calculator.operationtoken.Operand
import calculator.operationtoken.OperationToken
import calculator.operationtoken.Operator

object OperationParser {
    private const val DELIMITERS = " "

    fun parseOperation(operation: String): List<OperationToken> =
        operation.split(DELIMITERS)
            .map { token ->
                token.toIntOrNull()?.let { Operand.of(it) }
                    ?: run { Operator.of(token) }
            }
}
