package calculator

class Calculator {
    fun calculate(formula: String): Double {
        require(formula.isNotBlank()) { "값을 입력해 주세요" }

        val values = formula.split(FORMULA_SPLIT_DELIMITER)
        var outcome = values[0].toDouble()

        for (index in 1 until values.size step 2) {
            val operator = getOperator(values[index])
            val number = values[index + 1].toDouble()

            outcome = operator.operation(outcome, number)
        }
        return outcome
    }

    companion object {
        private const val FORMULA_SPLIT_DELIMITER = " "
    }
}
