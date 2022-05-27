package calculator

private const val DELIMITER = " "

class OperationUnits(formula: String) : Iterator<Pair<Operator, Double>> {

    private var operands = mutableListOf<Double>()

    private var operators = mutableListOf(Operator.ADDITION)

    private var index = 0

    private val lastIndex: Int

    init {
        formula.split(DELIMITER)
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .forEachIndexed(this::addOperationUnit)

        lastIndex = operands.lastIndex
    }

    private fun addOperationUnit(index: Int, operationUnit: String) {
        if (index % 2 == 0) {
            addOperand(operationUnit)
        } else {
            addOperator(operationUnit)
        }
    }

    private fun addOperand(operand: String) {
        try {
            operands += operand.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("연산 불가능한 피연산자가 입력되었습니다.: $operand")
        }
    }

    private fun addOperator(operator: String) {
        operators += Operator.get(operator)
    }

    override fun hasNext(): Boolean = index <= lastIndex

    override fun next(): Pair<Operator, Double> = Pair(operators[index], operands[index++])
}
