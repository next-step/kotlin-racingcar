package calculator

class Calculator(val inputString: String) {
    fun calculate(): Int {
        val expressions = Expressions(inputString)
        val firstOperand = expressions.operands.first()
        var result = firstOperand
        expressions.operators.forEachIndexed { index, value ->
            result = value.compute(result, expressions.operands[index + 1])
        }
        return result.value
    }
}
