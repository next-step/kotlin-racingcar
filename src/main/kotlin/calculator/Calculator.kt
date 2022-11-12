package calculator

import calculator.common.ExceptionCode
import calculator.common.Utils
import java.util.Stack

class Calculator {
    private val operator = OperatorImpl()
    private val utils = Utils()

    fun calculate(input: String?): Float {
        val stack = Stack<Float>()
        val inputList = inputValidation(input)
        val postFix = utils.infixToPostFix(inputList)
        println(postFix)
        postFix.map { it ->
            when {
                utils.isNumeric(it) -> {
                    stack.add(it.toFloat())
                }
                else -> {
                    val secondNum = stack.pop()
                    val firstNum = stack.pop()
                    when (it) {
                        "+" -> stack.add(operator.add(firstNum, secondNum))
                        "-" -> stack.add(operator.minus(firstNum, secondNum))
                        "*" -> stack.add(operator.multiple(firstNum, secondNum))
                        "/" -> stack.add(operator.divide(firstNum, secondNum))
                        // 이미 validation에서 걸렀는데 이 부분을 어떻게 처리해야할지 고민
                        else -> throw IllegalArgumentException(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())
                    }
                }
            }
        }
        return stack.pop()
    }

    private fun inputValidation(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(ExceptionCode.NOT_ALLOWED_NULL_OR_BLANK.getMessage())
        }
        val inputParsingList = input.split(" ")
        inputParsingList.mapIndexed { index, string ->
            when {
                // 숫자일 때
                index % 2 == 0 ->
                    if (!utils.isNumeric(string)) throw IllegalArgumentException(ExceptionCode.NOT_MATCHED_NUMERIC.getMessage())
                // 연산자일 때
                else ->
                    if (!utils.isOperator(string)) throw IllegalArgumentException(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())
            }
        }
        return inputParsingList
    }
}
