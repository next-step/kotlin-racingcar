package calculator.domain

class OperandsAndOperators(private val operands: Operands, private val operators: Operators) {

    fun operate(): Int {
        var sum = operands.pull()

        while (operators.hasNext()) {
            val operator = operators.pull()
            sum = operator.operate(sum, operands.pull())
        }

        return sum.value
    }
}
