package calculator

import calculator.operationtoken.Operand
import calculator.operationtoken.OperationToken
import calculator.operationtoken.Operator

class BasicCalculator() : Calculator {

    override fun calculate(operation: List<OperationToken>): Operand {
        // FIXME: as를 최소화 할 순 없을까?
        var result = operation.first() as Operand
        for (i in 1 until operation.size step 2) {
            val operator = operation[i] as Operator
            val operand = operation[i + 1] as Operand
            result = operator.execute(result, operand)
        }

        return result
    }
}
