package calculator.operation

class NonArithmeticOperator(override val operator: String) : Operator(operator) {

    override fun match(operator: String) = true

    override fun operate(leftOperand: Double, rightOperand: Double): Double {
        throw IllegalArgumentException("연산 불가능한 연산자가 입력되었습니다.: $operator")
    }
}
