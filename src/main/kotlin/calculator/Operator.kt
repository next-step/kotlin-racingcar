package calculator

sealed class Operator(val operator: String, val operationLambda: (leftOperand: Double, rightOperand: Double) -> Double) {

    fun match(operator: String) = this.operator == operator

    fun operate(leftOperand: Double, rightOperand: Double) = operationLambda(leftOperand, rightOperand)

    object Addition : Operator("+", { leftOperand, rightOperand -> leftOperand + rightOperand })
    object Subtraction : Operator("-", { leftOperand, rightOperand -> leftOperand - rightOperand })
    object Multiplication : Operator("*", { leftOperand, rightOperand -> leftOperand * rightOperand })
    object Division : Operator("/", { leftOperand, rightOperand ->
        check(rightOperand != 0.0) { "0 으로 나눌 수 없습니다." }
        leftOperand / rightOperand
    })
    class NonArithmetic(operator: String) : Operator(operator, { _, _ ->
        throw IllegalArgumentException("연산 불가능한 연산자가 입력되었습니다.: $operator")
    })
}
