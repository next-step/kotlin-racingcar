package step2

import step2.FourArithmeticOperation.Companion.getArithmeticOperation
import step2.FourArithmeticOperation.Companion.getArithmeticOperationFromString
import step2.FourArithmeticOperation.DIVIDE
import step2.FourArithmeticOperation.MINUS
import step2.FourArithmeticOperation.MULTIPLY
import step2.FourArithmeticOperation.PLUS
import java.math.BigDecimal
import kotlin.math.floor

class Calculator {
    fun calculate(string: String?): String {
        requireNotNull(string) { NULL_PARAM }
        require(string.isNotBlank()) { EMPTY_STRING_MESSAGE }

        val removedWhiteSpaceString = removeWhiteSpace(string)
        val addOperatorFirstPlace = replaceOperatorFirstPlace(removedWhiteSpaceString)

        StringValidator.validateString(addOperatorFirstPlace)

        val separatedStringList = splitString(addOperatorFirstPlace)
        val result = calculate(separatedStringList)
        val floorResult = removeTwoDigitAfterDecimalPoint(result)

        return convertResultToLongOrDouble(result, floorResult)
    }

    private fun removeWhiteSpace(string: String) = string.replace(" ", "")

    /**
     * 이 계산기의 Double값은 소숫점 첫째 자리까지만 계산합니다.
     * 이 때, 첫째 자리 값 이후의 값을 버린 값과 기존의 값이 같다면, 이 값을 Long으로 보여줄지, Double로 보여줄지 결정합니다.
     */
    private fun convertResultToLongOrDouble(result: Double, floorResult: Double): String =
        if (result == floorResult) {
            /**
             * 1, 1 의 경우 1을
             * 1.1, 1.1의 경우 1.1을 보여 줍니다.
             */
            checkNeedToUseDouble(result)
        } else {
            /**
             * 1.2 1.0로 값이 다른 경우 에는 result 값을 소수점 첫째 까지인 1.2로 보여 줍니다.
             */
            removeTwoDigitAfterDecimalPoint(result).toString()
        }

    /**
     * 결과 값을 Double로 보여줄 지, Long으로 보여줄지 값 올림을 통해 계산합니다. (0.1이라도 높으면 올림)
     * ex) 1.1 -> 올림 = 2.0 즉, 소수점 첫째자리가 반드시 0 인경우에만 Long으로 변환하고 아닌 경우 그대로 double인 result 값을 사용합니다.
     * 예시로, 1.1-0.1 = 1.0 -> 1 로 변경해줍니다.
     */
    private fun checkNeedToUseDouble(result: Double) =
        if (result == kotlin.math.ceil(result)) result.toLong().toString() else result.toString()

    // 소수점 둘째 자리에서 올림
    private fun removeTwoDigitAfterDecimalPoint(result: Double) = (floor(result * 10) / 10)

    /**
     * 연산을 차례 대로 진행 합니다.
     */
    private fun calculate(list: List<String>) = list.reduceIndexed { index, total, next ->
        if (index == 0) {
            total
        } else {
            val firstOperand = total.toBigDecimal()
            val checkSecondOperand = next.replace(next.first().toString(), "")
            check(checkSecondOperand.toDouble() != 0.0) { DO_NOT_DIVIDE_ZERO }
            val secondOperand = checkSecondOperand.toBigDecimal()
            val operator = getArithmeticOperationFromString(next.first())

            calculate(firstOperand, secondOperand, operator).toString()
        }
    }.toDouble()

    /**
     * 문자+숫자형식으로 문자열을 자릅니다
     */
    private fun splitString(addOperatorFirstPlace: String): List<String> {
        val regex = "((?=[+\\-*/]))".toRegex()
        return addOperatorFirstPlace.split(regex).filter { it.isNotBlank() }
    }

    /**
     * 가장 첫번째 문자열에 + 를 붙여줍니다 ex) 2+3 => +2+3
     * 다만, 첫번째 문자열이 0~9 인 경우에만 붙여주고
     * -가 붙어 있거나, +가 이미 있는 경우엔 문자열 그대로 사용합니다.
     * 또한 * / # 와 같이 첫번째 자리에 붙을 수 없는 값들은 IllgealStateException을 뱉습니다
     */
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

    companion object {
        private const val NULL_PARAM = "문자열은 null일 수 없어요"
        private const val EMPTY_STRING_MESSAGE = "계산기의 값은 공백일 수 없어요"
        private const val WRONG_STRING = "잘못 된 식 이예요"
        private const val DO_NOT_DIVIDE_ZERO = "0으로 나누지 마세요"
    }
}
