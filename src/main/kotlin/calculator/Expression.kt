package calculator

class Expression(
    private val inputs: String
) {

    fun addOperand(input: String): Expression {
        return Expression("$inputs $input")
    }

    fun addOperator(input: String): Expression {
        val operator = Operator.of(input)
        return Expression("$inputs ${operator.operator}")
    }

    override fun toString(): String {
        return inputs
    }

}