package calculator

class Calculator {
    private val formulaConverter = FormulaConverter()

    fun calculate(formula: String): Int {
        return formulaConverter.convert(formula).run {
            var resultValue = startValue
            while (true) {
                nextFormulaElement()?.also { resultValue = it.operator.calculation(resultValue, it.operand) } ?: break
            }
            resultValue.value.toInt()
        }
    }
}
