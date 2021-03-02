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
        if (formula.isBlank())
            throw IllegalArgumentException("수식이 빈 값입니다.")
    }

    private fun calculate(formula: String): Double {
        val parsedFormular = formula.split(" ")
        var result = parsedFormular[0].toDouble()

        for (i in 1 until parsedFormular.size step 2) {
            result = Operator.calculate(parsedFormular[i], result, parsedFormular[i + 1].toDouble())
        }
        return result
    }
}
