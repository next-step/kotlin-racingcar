package calculator

private const val SEPARATOR = " "

class StringCalculator {

    companion object {
        fun calculate(input: String): Int {
            val operands = Operands()
            val operators = Operators()
            input.split(SEPARATOR).forEach {
                addParam(it, operands, operators)
                if (isCalculable(operands, operators)){
                    val x = operands.getOperand();
                    val y = operands.getOperand();
                    operands.add(operators.getOperator().calculate(x,y));
                }
            }
            return operands.getResult()
        }

        private fun isCalculable(operands: Operands, operators: Operators) =
            operands.isCalculable() && operators.isCalculable()

        private fun addParam(param: String, operands: Operands, operators: Operators) {
            if (Operator.isOperator(param)) {
                operators.add(param);
                return
            }
            operands.add(param);
        }
    }
}
