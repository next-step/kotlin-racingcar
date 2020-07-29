package step2

class Calculator {

    fun calculate(formula: String): Double {
        require(formula.isNotBlank()) { "값을 입력해 주세요" }

        val formulaSplitDelimiter = " "
        val values = formula.split(formulaSplitDelimiter)
        var outcome = values[0].toDouble()

        for (index in 1 until values.size step 2) {
            val operator = Operator(values[index])
            val number = values[index + 1].toDouble()

            outcome = operator.calculate(outcome, number)
        }
        return outcome
    }
}
