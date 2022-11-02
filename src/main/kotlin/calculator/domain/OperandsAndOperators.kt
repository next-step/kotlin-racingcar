package calculator.domain

class OperandsAndOperators(private val operands: Operands, private val operators: Operators) {

    private var sum = Operand(0)

    fun operate() {
        sum = operands.pull()

        while (operators.hasNext()) {
            val operator = operators.pull()
            sum = operator.operate(sum, operands.pull())
        }
    }

    fun getResult(): Int {
        return sum.value
    }
}
