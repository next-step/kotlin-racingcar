package calculator.domain

class Calculator(private val operands: List<String>, private val operators: List<String>) {

    fun calculate(): Number {
        val mutableOperands = operands.toMutableList()
        val mutableOperators = operators.toMutableList()

        var result = Number(mutableOperands.removeAt(0))

        while (mutableOperands.isNotEmpty()) {
            val operator = Operator.of(mutableOperators.removeAt(0))
            result = operator.operate(result, Number(mutableOperands.removeAt(0)))
        }

        return result
    }
}
