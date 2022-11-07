package calculator.interfaces.input

import calculator.domain.operation.enums.Operator
import java.util.StringJoiner

object StepInputConsole {

    private const val JOINER_DELIMITER = " "

    private const val INPUT_NUMBER_COMMENT = "숫자를 입력해주세요"
    private const val INPUT_OPERATOR_COMMENT = "연산자를 입력해주세요"
    private const val INPUT_CORRECT_NUMBER_COMMENT = "올바른 숫자를 입력해주세요"
    private const val INPUT_CORRECT_OPERATOR_COMMENT = "올바른 연산자를 입력해주세요"

    private const val YES = "Y"
    private const val NO = "N"

    private const val CONTINUE_QUESTION = "연산을 계속 하시겠습니까? $YES: 넵 $NO: 아니요"
    private const val REPEAT_CORRECT_ANSWER = "답변을 제대로 해주세요"

    fun input(): String {
        val stringJoiner = StringJoiner(JOINER_DELIMITER)

        val firstNumber = inputNumber(INPUT_NUMBER_COMMENT)

        stringJoiner.add(firstNumber)

        while (checkContinue()) {
            val (operator, number) = inputOperatorWithNumber()
            stringJoiner.add(operator)
            stringJoiner.add(number)
        }

        return stringJoiner.toString()
    }

    private fun inputNumber(comment: String): String =
        try {
            println(comment)
            readln().validateNumber()
        } catch (e: IllegalArgumentException) {
            inputNumber(e.localizedMessage)
        }

    private fun inputOperatorWithNumber(): Pair<String, String> =
        try {
            println(INPUT_OPERATOR_COMMENT)
            val operator = readln()
            validateOperator(operator)

            println(INPUT_NUMBER_COMMENT)
            val number = readln().validateNumber()

            operator to number
        } catch (e: IllegalArgumentException) {
            inputOperatorWithNumber()
        }

    private fun String.validateNumber() =
        try {
            apply {
                this.toInt()
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INPUT_CORRECT_NUMBER_COMMENT)
        }

    private fun validateOperator(string: String) {
        try {
            Operator.operatorOf(string)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(INPUT_CORRECT_OPERATOR_COMMENT)
        }
    }

    private fun checkContinue(): Boolean {
        println(CONTINUE_QUESTION)
        return when (readln().uppercase()) {
            YES -> true
            NO -> false
            else -> {
                println(REPEAT_CORRECT_ANSWER)
                checkContinue()
            }
        }
    }
}
