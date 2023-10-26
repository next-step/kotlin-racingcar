class Calculator {

    companion object {
        const val OPERATION_COMPONENT_INTERVAL = 2
        const val UNNECESSARY_DECIMAL = '0'
        const val DECIMAL_LENGTH = 2
    }

    fun calculate(formula: String): String {
        val formulaComponents = FormulaParser().parse(formula)

        val result = calculateResult(formulaComponents)

        return removeDecimalPoint(result)
    }

    private fun calculateResult(formulaComponents: List<String>): Float {
        var result = formulaComponents[0].toFloat()

        for (i in 1 until formulaComponents.size step OPERATION_COMPONENT_INTERVAL) {
            val operator = Operator.from(formulaComponents[i])
            val num = formulaComponents[i + 1]

            result = operator.operation(result, num.toFloat())
        }

        return result
    }

    private fun removeDecimalPoint(num: Float): String {
        var result = num.toString()

        if (result[result.length - 1] == UNNECESSARY_DECIMAL) {
            result = result.substring(0, result.length - DECIMAL_LENGTH)
        }
        return result
    }
}
