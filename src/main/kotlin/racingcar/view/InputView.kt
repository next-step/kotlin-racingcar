package racingcar.view

import racingcar.exception.RacingCarException
import racingcar.exception.RacingCarException.READ_LINE_IS_EXCEEDED_FIVE_CHAR_EXCEPTION
import racingcar.exception.RacingCarException.READ_LINE_IS_NOT_POSITIVE_NUM_EXCEPTION
import racingcar.exception.RacingCarException.READ_LINE_IS_NULL_EXCEPTION

class InputView(
    private val inputLine: () -> String? = {
        readLine()
    }
) {

    fun getCarNames(): List<String> {
        println(CAR_NAMES_QUESTION)
        val splitList = splitList(inputLine())
        return checkStringLength(splitList)
    }

    fun getNumberOfAttempts(): Int {
        println(NUMBER_OF_ATTEMPTS_QUESTION)
        val integerCheckedInput = checkInteger(inputLine())
        require(integerCheckedInput > 0) {
            READ_LINE_IS_NOT_POSITIVE_NUM_EXCEPTION
        }
        return integerCheckedInput
    }

    private fun checkInteger(input: String?): Int {
        return input?.toIntOrNull()
            ?: throw IllegalArgumentException(RacingCarException.READ_LINE_IS_NOT_A_NUMBER_EXCEPTION)
    }

    private fun splitList(input: String?): List<String> {
        return input?.trim()?.split(RACING_INPUT_DELIMITER) ?: throw IllegalArgumentException(
            READ_LINE_IS_NULL_EXCEPTION
        )
    }

    private fun checkStringLength(list: List<String>): List<String> {
        list.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException(READ_LINE_IS_EXCEEDED_FIVE_CHAR_EXCEPTION)
            }
        }
        return list
    }

    companion object {
        private const val CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val NUMBER_OF_ATTEMPTS_QUESTION = "시도할 횟수는 몇 회인가요?"
        private const val RACING_INPUT_DELIMITER = ","
    }
}
