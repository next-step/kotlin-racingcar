package calculator

class Calculator {
    var total: Long = 0

    fun calculate(calculatorFormula: String) {
        val parsedCalculateFormula = calculatorFormula.split(' ')

        val total = parsedCalculateFormula[0].toLong()
        val operand = parsedCalculateFormula[2].toLong()

        this.total = total + operand
    }
}
