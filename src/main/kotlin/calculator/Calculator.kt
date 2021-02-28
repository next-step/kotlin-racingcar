package calculator

class Calculator(val inputString: String) {
    fun calculate(): Int {
        val expressions = Expressions(inputString)
        var sum = expressions.operands.first().value
        expressions.operators.withIndex()
            .forEach {
                sum = it.value.compute(sum, expressions.operands[it.index + 1].value)
            }
        return sum
    }
}
