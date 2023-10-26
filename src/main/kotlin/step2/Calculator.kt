package step2

import step2.FourArithmeticOperation.Companion.getArithmeticOperation
import step2.FourArithmeticOperation.Companion.getArithmeticOperationFromString
import step2.FourArithmeticOperation.DIVIDE
import step2.FourArithmeticOperation.MINUS
import step2.FourArithmeticOperation.MULTIPLY
import step2.FourArithmeticOperation.PLUS
import java.math.BigDecimal
import kotlin.math.floor
import kotlin.math.roundToLong

class Calculator {
    fun calculate(string: String?): String {
        requireNotNull(string) { NULL_PARAM }
        require(string.isNotBlank()) { EMPTY_STRING_MESSAGE }

        val notContainedWhiteSpaceString = string.replace(" ", "")
        val addOperatorFirstPlace = replaceOperatorFirstPlace(notContainedWhiteSpaceString)

        validateString(addOperatorFirstPlace)
        val splitStringList = splitString(addOperatorFirstPlace)
        val result = calculate(splitStringList)
        val floorResult = removeTwoDigitAfterDecimalPoint(result)

        return convertResultToLongOrDouble(result, floorResult)
    }

    private fun convertResultToLongOrDouble(result: Double, floorResult: Double) =
        if (result == floorResult) {
            checkNeedToUseDouble(result)
        } else {
            ((floor(result * 10)).roundToLong().toDouble() / 10).toString()
        }

    private fun checkNeedToUseDouble(result: Double) =
        if (result == kotlin.math.ceil(result)) result.toLong().toString() else result.toDouble().toString()

    // 소수점 둘째 자리에서 반올림
    private fun removeTwoDigitAfterDecimalPoint(result: Double) = (floor(result * 10)).roundToLong().toDouble() / 10

    private fun calculate(list: List<String>): Double {
        val result = list.reduceIndexed { index, total, next ->
            if (index == 0) {
                total
            } else {
                val firstOperand = total.toBigDecimal()
                val secondOperand = next.replace(next.first().toString(), "").toBigDecimal()
                val operator = getArithmeticOperationFromString(next.first())

                calculate(
                    firstOperand,
                    secondOperand,
                    operator
                )
            }.toString()
        }
        return result.toDouble()
    }

    private fun splitString(addOperatorFirstPlace: String): List<String> {
        val regex = "((?=[+\\-*/]))".toRegex()
        return addOperatorFirstPlace.split(regex).filter { it.isNotBlank() }
    }

    private fun replaceOperatorFirstPlace(notContainedWhiteSpaceString: String) =
        when {
            notContainedWhiteSpaceString.first().isNumber() -> "+$notContainedWhiteSpaceString"
            getArithmeticOperation(MINUS) == notContainedWhiteSpaceString.first()
                .toString() -> notContainedWhiteSpaceString

            getArithmeticOperation(PLUS) == notContainedWhiteSpaceString.first()
                .toString() -> notContainedWhiteSpaceString

            else -> throw IllegalArgumentException(WRONG_STRING)
        }

    private fun Char.isNumber(): Boolean {
        return when (this) {
            in '0'..'9' -> true
            else -> false
        }
    }

    /**
     * 실제 연산
     */
    private fun calculate(
        firstOperand: BigDecimal,
        secondOperand: BigDecimal,
        operator: FourArithmeticOperation
    ): BigDecimal {
        return when (operator) {
            PLUS -> {
                firstOperand + secondOperand
            }

            MINUS -> {
                firstOperand - secondOperand
            }

            MULTIPLY -> {
                firstOperand * secondOperand
            }

            DIVIDE -> {
                firstOperand / secondOperand
            }
        }
    }

    private fun Char.isMultiplyOrDivide() =
        this.toString() == getArithmeticOperation(MULTIPLY) || this.toString() == getArithmeticOperation(DIVIDE)

    private fun Char.isFourArithmeticCalculation(): Boolean {
        return when (this@isFourArithmeticCalculation.toString()) {
            getArithmeticOperation(PLUS),
            getArithmeticOperation(MINUS),
            getArithmeticOperation(MULTIPLY),
            getArithmeticOperation(DIVIDE) -> true

            else -> false
        }
    }

    /**
     * 문자열이 유효한지 한번에 체크
     */
    private fun validateString(string: String) {
        validateFirstAndLast(string)
        validateDuplicatedOperation(string)
    }

    /**
     * 문자열의 처음과 끝이 * / 연산이면 IllegalArgumentException
     */
    private fun validateFirstAndLast(string: String) {
        require(
            string.first().isMultiplyOrDivide().not() &&
                string.last().isMultiplyOrDivide().not()
        ) { START_STRING_CAN_NOT_BE_OPERATION }
    }

    /**
     * 연산자가 두개 이상 동시에 들어오는 경우
     */
    private fun validateDuplicatedOperation(string: String) {
        string.mapIndexed { index, char ->
            if (index != 0) { // 1~마지막
                if (char.isFourArithmeticCalculation() && string[index - 1].isFourArithmeticCalculation()) {
                    error(DUPLICATED_OPERATION)
                }
            }
        }
    }

    companion object {
        private const val NULL_PARAM = "문자열은 null일 수 없어요"
        private const val EMPTY_STRING_MESSAGE = "계산기의 값은 공백일 수 없어요"
        private const val START_STRING_CAN_NOT_BE_OPERATION = "문자열의 시작, 끝은 \"*, /\" 일 수 없어요"
        private const val DUPLICATED_OPERATION = "연산자가 2개 이상 연속으로 사용됐어요"
        private const val WRONG_STRING = "잘못 된 식 이예요"
    }
}
