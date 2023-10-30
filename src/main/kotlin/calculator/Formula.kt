package calculator

class Formula(private val formula: String) {

    private val operands: List<Operand>
    private val operators: List<Operator>

    init {
        operators = initOperator()
        operands = initOperand()
        validateFormula()
    }

    fun calculateFormula(): Int {
        var result = operands[0].getValue()

        for (i in 1 until operands.size) {
            val operator = operators[i - 1]
            val operand = operands[i].getValue()

            result = operator.calculate(result, operand)
        }

        return result
    }

    private fun initOperand(): List<Operand> {
        return formula.split(DELIMITER)
            .filterIndexed { index, _ -> index % 2 == 0 }
            .map { Operand.from(it) }
    }

    private fun initOperator(): List<Operator> {
        return formula.split(DELIMITER)
            .filterIndexed { index, _ -> index % 2 == 1 }
            .map { Operator.from(it) }
    }

    private fun validateFormula() {
        if (operands.size != operators.size + 1) {
            throw IllegalArgumentException("수식의 형식이 잘못되었습니다.")
        }
    }

    companion object {
        private const val DELIMITER = " "
    }
}
