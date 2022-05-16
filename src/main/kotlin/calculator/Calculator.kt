package calculator

object Calculator {
    fun calculate(calculatorFormula: String?): Float {
        require(!calculatorFormula.isNullOrEmpty()) {
            throw IllegalArgumentException("유효하지 않은 계산식 입니다.")
        }

        val parsedCalculateFormula = calculatorFormula.split(" ")
        val restParsedCalculateFormula = parsedCalculateFormula.drop(1)
        var total = try {
            parsedCalculateFormula[0].toFloat()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("유효하지 않은 계산식 입니다.")
        }

        for (i: Int in restParsedCalculateFormula.indices step(2)) {
            val operand = try {
                restParsedCalculateFormula[i + 1].toFloat()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("유효하지 않은 계산식 입니다.")
            }
            val op = restParsedCalculateFormula[i]

            Operator.evaluate(total, operand, op).also { total = it }
        }

        return total
    }
}
