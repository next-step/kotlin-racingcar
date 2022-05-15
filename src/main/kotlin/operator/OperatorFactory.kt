package operator

class OperatorFactory(
    private val plusOperator: Operator = PlusOperator(),
    private val subtractOperator: Operator = SubtractOperator(),
    private val divideOperator: Operator = DivideOperator(),
    private val multiplyOperator: Operator = MultiplyOperator()

) {

    fun getOperator(operator: String): Operator =
        when (operator) {
            "+" -> plusOperator
            "-" -> subtractOperator
            "/" -> divideOperator
            "*" -> multiplyOperator
            else -> throw IllegalArgumentException("This operator is not acceptable. operator: $operator")
        }
}
