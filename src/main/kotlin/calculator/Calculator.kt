package calculator

object Calculator {
    fun calculate(calculatorFormula: String?): Float {
        require(!calculatorFormula.isNullOrEmpty()) {
            throw IllegalArgumentException("유효하지 않은 계산식 입니다.")
        }

        val parsedCalculateFormula = calculatorFormula.split(" ")
        val restParsedCalculateFormula = parsedCalculateFormula.drop(1)
        var total = parsedCalculateFormula[0].toFloat()

        for (i: Int in restParsedCalculateFormula.indices step(2)) {
            val operand = restParsedCalculateFormula[i + 1].toFloat()
            val operator = restParsedCalculateFormula[i]

            calculate(total, operand, operator).also { total = it }
        }

        return total
    }

    private fun calculate(total: Float, operand: Float, operator: String): Float = Operator.evaluate(total, operand, operator)
}
