package calculator

private const val SEPARATOR = " "

class StringCalculator {

    companion object {
        fun calculate(input: String): Int {
            validateInput(input)
            val operands = Operands()
            val operators = Operators()
            input.split(SEPARATOR).forEach {
                addParam(it, operands, operators)
                if (isCalculable(operands, operators)) {
                    val x = operands.getOperand()
                    val y = operands.getOperand()
                    operands.add(getResult(operators, x, y))
                }
            }
            return operands.getResult()
        }

        private fun validateInput(input: String) {
            if (input.isNullOrBlank()) {
                throw IllegalArgumentException("입력값이 비어 있습니다.")
            }
        }

        private fun getResult(operators: Operators, x: Int, y: Int): Int {
            try {
                return operators.getOperator().calculate(x, y)
            } catch (e: ArithmeticException) {
                throw IllegalArgumentException("0으로는 나눌수 없습니다.", e)
            }
        }

        private fun isCalculable(operands: Operands, operators: Operators) =
            operands.isCalculable() && operators.isCalculable()

        private fun addParam(param: String, operands: Operands, operators: Operators) {
            if (Operator.isOperator(param)) {
                operators.add(param)
                return
            }
            operands.add(param)
        }
    }
}
