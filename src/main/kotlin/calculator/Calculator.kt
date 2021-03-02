package calculator

class Calculator {

    fun execute(formula: String?): Double {
        return formula?.let {
            validate(it)
            calculate(it)
        } ?: run {
            throw IllegalArgumentException("수식이 null입니다.")
        }
    }

    private fun validate(formula: String) {
        require(formula.isNotBlank()) { "수식이 빈 값입니다." }
    }

    private fun calculate(formula: String): Double {
        val parsedFormular = formula.split(FORMULA_DELIMITERS)
        var result = parsedFormular[0].toDouble()

        for (numIndex in 1 until parsedFormular.size step 2) {
            val signIndex = numIndex + 1
            result = Operator.calculate(parsedFormular[numIndex], result, parsedFormular[signIndex].toDouble())
        }
        return result
    }

    companion object {
        const val FORMULA_DELIMITERS = " "
    }
}
