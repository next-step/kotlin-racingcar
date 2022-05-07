package calculator

class Calculator {
    var total: Float = 0F

    fun calculate(calculatorFormula: String) {
        val parsedCalculateFormula = calculatorFormula.split(' ')

        val total = parsedCalculateFormula[0].toFloat()
        val operand = parsedCalculateFormula[2].toFloat()
        val operator = parsedCalculateFormula[1]

        if (operator == "+") {
            this.total = total + operand
        }

        if (operator == "-") {
            this.total = total - operand
        }

        if (operator == "*") {
            this.total = total * operand
        }

        if (operator == "/") {
            this.total = total / operand
        }

        if (parsedCalculateFormula.size > 3) {
            val restParsedCalculateFormula = parsedCalculateFormula.drop(3)
            calculate("${this.total} ${restParsedCalculateFormula.joinToString(" ")}")
        }
    }
}
