package calculator

class StringCalculator {
    fun calculate(operands: MutableList<Operand>, operators: MutableList<Operator>): Double {
        if (operands.isEmpty() || operators.isEmpty()) {
            throw IllegalArgumentException("operands, operators는 1개 이상이어야 합니다. operands: $operands operators: $operators")
        }
        var result = operands.removeFirst().value

        while (operands.isNotEmpty()) {
            val operand = operands.removeFirst()
            val operator = operators.removeFirst()

            result = operator.operate(result, operand)
        }
        return result
    }
}
