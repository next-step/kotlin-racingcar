package step2

import step2.exception.CalculatorMessage
import step2.exception.CustomException

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
                DIVIDE.operator -> if (secondNum == 0.0) throw CustomException(CalculatorMessage.CAN_NOT_DIVIDED_BY_ZERO) else DIVIDE.expression(firstNum, secondNum)
                else -> throw IllegalArgumentException(CalculatorMessage.NOT_OPERATOR.message)
            }
        }
    }
}
