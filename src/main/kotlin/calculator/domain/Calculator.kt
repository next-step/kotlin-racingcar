package calculator.domain

class Calculator(private val operands: List<String>, private val operators: List<String>) {

    fun calculate(): Int {
        val mutableOperands = operands.toMutableList()
        val mutableOperators = operators.toMutableList()

        var result = mutableOperands.removeAt(0).toInt()

        while (mutableOperands.isNotEmpty()) {
            val operator = Operator.of(mutableOperators.removeAt(0))
            result = operator.operate(result, mutableOperands.removeAt(0).toInt())
        }

        return result
    }
}
