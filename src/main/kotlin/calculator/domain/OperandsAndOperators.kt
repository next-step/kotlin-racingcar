package calculator.domain

class OperandsAndOperators(private val operands: Operands, private val operators: Operators) {

    fun operate(): Int {
        var sum = operands.poll()

        while (operators.hasNext()) {
            val operator = operators.poll()
            sum = operator.operate(sum, operands.poll())
        }

        return sum.value
    }
}
