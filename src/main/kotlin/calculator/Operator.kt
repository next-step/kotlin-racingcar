package calculator

enum class Operator(private val op: String, private val operationLambda: (leftOperand: Double, rightOperand: Double) -> Double) {

    ADDITION("+", { leftOperand, rightOperand -> leftOperand + rightOperand }),
    SUBTRACTION("-", { leftOperand, rightOperand -> leftOperand - rightOperand }),
    MULTIPLICATION("*", { leftOperand, rightOperand -> leftOperand * rightOperand }),
    DIVISION("/", { leftOperand, rightOperand ->
        check(rightOperand != 0.0) { "0 으로 나눌 수 없습니다." }
        leftOperand / rightOperand
    });

    companion object {

        private val OPERATORS_BY_OP = values().associateBy { it.op }

        fun get(operator: String) = let {
            OPERATORS_BY_OP[operator] ?: throw IllegalArgumentException("연산 불가능한 연산자가 입력되었습니다.: $operator")
        }
    }

    fun operate(leftOperand: Double, rightOperand: Double) = operationLambda(leftOperand, rightOperand)
}
