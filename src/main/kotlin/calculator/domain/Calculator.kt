package calculator.domain

class Calculator(private val operands: List<Number>, private val operators: List<Operator>) {

    fun calculate(): Number {
        val mutableOperands = operands.toMutableList()
        val mutableOperators = operators.toMutableList()

        var result = mutableOperands.removeAt(0)

        while (mutableOperands.isNotEmpty()) {
            val operator = mutableOperators.removeAt(0)
            result = operator.operate(result, mutableOperands.removeAt(0))
        }

        return result
    }
}
