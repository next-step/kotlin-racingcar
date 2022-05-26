package calculator

object Calculator {

    private const val INITIAL_ACCUMULATOR = 0.0

    fun calculate(formula: String?): Double {
        require(!formula.isNullOrBlank()) { "연산 불가능한 입력 입니다." }
        val operationUnits = OperationUnits(formula)

        var result = INITIAL_ACCUMULATOR
        for ((operator, operand) in operationUnits) {
            result = operator.operate(result, operand)
        }
        return result
    }
}
