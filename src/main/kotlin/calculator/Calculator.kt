package calculator

class Calculator {
    private val formulaConverter = FormulaConverter()

    fun calculate(formula: String): Int {
        return formulaConverter.convert(formula).let {
            var resultValue = it.startValue

            while (true) {
                it.nextFormulaElement()?.also { formulaElement ->
                    resultValue = formulaElement.type.calculation(resultValue, formulaElement.value)
                } ?: break
            }
            resultValue.toInt()
        }
    }
}
