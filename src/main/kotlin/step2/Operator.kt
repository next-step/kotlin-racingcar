package step2

enum class Operator(private val operator: String, val expression: (firstNum: Double, secondNum: Double) -> Double) {

    SUM("+", { firstNum, secondNum -> firstNum + secondNum }),
    SUBTRACTION("-", { firstNum, secondNum -> firstNum - secondNum }),
    MULTIPLY("*", { firstNum, secondNum -> firstNum * secondNum }),
    DIVIDE("/", { firstNum, secondNum -> firstNum / secondNum });

    companion object {
        fun execute(paramOperator: String, firstNum: Double, secondNum: Double): Double {
            return when (paramOperator) {
                SUM.operator -> SUM.expression(firstNum, secondNum)
                SUBTRACTION.operator -> SUBTRACTION.expression(firstNum, secondNum)
                MULTIPLY.operator -> MULTIPLY.expression(firstNum, secondNum)
                DIVIDE.operator -> if (secondNum == 0.0) throw IllegalArgumentException(Message.CAN_NOT_DIVIDED_BY_ZERO.message) else DIVIDE.expression(firstNum, secondNum)
                else -> throw IllegalArgumentException(Message.NOT_OPERATOR.message)
            }
        }
    }
}
