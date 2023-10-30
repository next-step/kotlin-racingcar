class Constant {
    companion object {
        const val CALCULATE_DELIMETER = " "
    }
}

class Calculator(val formula: String) {
    private val formulas = formula.split(Constant.CALCULATE_DELIMETER).toMutableList()
    private val numberPattern = Regex("\\d+")

    fun calculate(): Int {
        CaculatorValidator.validate(formulas)

        var prev = 0
        while (formulas.isNotEmpty()) {
            val word = formulas.removeFirst()
            if (numberPattern.matches(word)) {
                prev = word.toInt()
            } else {
                val first = prev
                val second = formulas.removeFirst().toInt()
                prev = Operator(Operator.OperatorSymbol.of(word)).operate(first, second)
            }
        }

        return prev
    }
}
