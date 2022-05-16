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
            val op = restParsedCalculateFormula[i]

            Operator.evaluate(total, operand, op).also { total = it }
        }

        return total
    }
}
