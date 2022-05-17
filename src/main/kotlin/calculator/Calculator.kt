package calculator

object Calculator {
    fun calculate(calculatorFormula: String?): Float {
        require(!calculatorFormula.isNullOrEmpty()) { "유효하지 않은 계산식 입니다." }

        val parsedCalculateFormula = calculatorFormula.split(" ")
        val restParsedCalculateFormula = parsedCalculateFormula.drop(1)
        var total = parsedCalculateFormula[0].toFloatOrThrow()

        for (i in restParsedCalculateFormula.indices step (2)) {
            val operand = restParsedCalculateFormula[i + 1].toFloatOrThrow()
            val op = restParsedCalculateFormula[i]

            total = Operator.find(op).evaluate(total, operand)
        }

        return total
    }

    private fun String.toFloatOrThrow(): Float = toFloatOrNull() ?: throw IllegalArgumentException("유효하지 않은 계산식 입니다.")
}
