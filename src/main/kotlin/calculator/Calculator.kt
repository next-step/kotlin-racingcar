package calculator

import calculator.common.InputValidation
import calculator.common.OperatorHelper
import calculator.enums.ArithmeticOperator
import calculator.enums.ExceptionCode
import java.util.Stack

class Calculator {
    private val operator = SimpleOperator()
    private val utils = OperatorHelper()
    private val inputValidation = InputValidation()

    fun calculate(input: String?): Float {
        val stack = Stack<Float>()
        val inputList = inputValidation.validate(input)
        val postFix = utils.infixToPostFix(inputList)
        postFix.forEach { it ->
            when {
                utils.isNumeric(it) -> {
                    stack.add(it.toFloat())
                }
                utils.isOperator(it) -> {
                    val secondNum = stack.pop()
                    val firstNum = stack.pop()
                    when (it) {
                        ArithmeticOperator.PLUS.operator -> stack.add(operator.add(firstNum, secondNum))
                        ArithmeticOperator.MINUS.operator -> stack.add(operator.minus(firstNum, secondNum))
                        ArithmeticOperator.MULTIPLE.operator -> stack.add(operator.multiple(firstNum, secondNum))
                        ArithmeticOperator.DIVIDE.operator -> stack.add(operator.divide(firstNum, secondNum))
                        // 이미 validation에서 걸렀는데 이 부분을 어떻게 처리해야할지 고민
                        else -> throw IllegalArgumentException(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())
                    }
                }
            }
        }
        return stack.pop()
    }
}
