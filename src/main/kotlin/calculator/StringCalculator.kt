package calculator

private const val SEPARATOR = " "

object StringCalculator {
    fun calculate(input: String): Int {
        validateInput(input)
        val operands = Operands()
        val operators = Operators()
        input.split(SEPARATOR).forEach {
            addParam(it, operands, operators)
            if (isCalculable(operands, operators)) {
                calculate(operands, operators)
            }
        }
        return operands.getResult()
    }

    private fun calculate(operands: Operands, operators: Operators) {
        val x = operands.firstOperand()
        val y = operands.firstOperand()
        val operator = operators.firstOperator()
        operands.add(operator.calculate(x, y))
    }

    private fun validateInput(input: String) =
        require(!input.isNullOrBlank()) { "입력값이 비어 있습니다." }

    private fun isCalculable(operands: Operands, operators: Operators) =
        operands.isCalculable() && operators.isCalculable()

    private fun addParam(param: String, operands: Operands, operators: Operators) {
        Operator.valueOf(operator = param)?.let {
            operators.add(it)
            return
        }
        operands.add(param)
    }
}
