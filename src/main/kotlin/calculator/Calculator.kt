package calculator

import calculator.operationtoken.Operand
import calculator.operationtoken.OperationToken

interface Calculator {
    fun calculate(operation: List<OperationToken>): Operand
}
