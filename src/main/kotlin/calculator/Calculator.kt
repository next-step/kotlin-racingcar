package calculator

object Calculator {

    fun calculate(formula: Formula): Int {
        var results = formula.initValue

        formula.tokens.forEach { token ->
            val operator = token.operator
            val nextValue = token.operand

            results = operator.getResult(results, nextValue)
        }

        return results
    }
}
