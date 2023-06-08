package study.step2

class Calculator {

    fun execute(expression: String? = null): Int {
        val operation = Operation.parse(expression)
        var result = 0

        var left: Operand? = operation.pollOperand()
        var right: Operand? = operation.pollOperand()
        var operator: Operator? = operation.pollOperator()

        do {
            result = operator!!.apply(left!!, right!!)

            left = Operand.of(result.toString())
            right = operation.pollOperand()
            operator = operation.pollOperator()

        } while(right != null)

        return result
    }
}
