package calculator

object Calculator {

    private const val INITIAL_ACCUMULATOR = 0.0

    private const val DELIMITER = " "

    fun calculate(formula: String?): Double {
        validateFormula(formula)

        val operationUnits = ("+ $formula").split(DELIMITER)
            .map { it.trim() }
            .filter { it.isNotBlank() }

        var accumulator = INITIAL_ACCUMULATOR
        repeat(countOperationPair(operationUnits.size)) {
            val (operator, operand) = extractOperationPair(it, operationUnits)
            accumulator = Operator.operate(operator, accumulator, operand)
        }
        return accumulator
    }

    private fun validateFormula(formula: String?) {
        require(!formula.isNullOrBlank()) { "연산 불가능한 입력 입니다." }
    }

    private fun countOperationPair(operationUnitCount: Int) = operationUnitCount / 2

    private fun extractOperationPair(operationTurn: Int, operationUnits: List<String>): Pair<String, Double> {
        val index = operationTurn * 2
        val (operator, operand) = operationUnits.subList(index, index + 2)

        try {
            return Pair(operator, operand.toDouble())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("연산 불가능한 피연산자가 입력되었습니다.: $operand")
        }
    }
}
