package racingcar.utils

import racingcar.dto.InputDto
import racingcar.exception.InvalidInputException

private const val QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val QUESTION_FOR_GAME_COUNT = "시도할 횟수는 몇 회인가요?"
private const val DELIMITER = ","
private const val EXCEPTION_MSG_GAME_COUNT = "게임 횟수는 숫자만 입력 가능합니다."

class InputUtils {
    companion object {
        fun askQuestions(): InputDto {
            val carCount = getCarCountFromInput()
            val gameCount = getGameCountFromInput()

            return InputDto(carCount, gameCount)
        }

        private fun getCarCountFromInput(): List<String> {
            println(QUESTION_FOR_CAR_NAMES)
            val readCarNames = iterateToGetValidInput(QUESTION_FOR_CAR_NAMES)

            return convertToNames(readCarNames)
        }

        private fun getGameCountFromInput(): Int {
            println(QUESTION_FOR_GAME_COUNT)
            val readGameCount = iterateToGetValidInput(QUESTION_FOR_GAME_COUNT)

            return convertToGameCount(readGameCount)
        }

        private fun iterateToGetValidInput(question: String): String {
            var readLine = readLine()

            while (readLine.isNullOrBlank()) {
                println(question)
                readLine = readLine()
            }

            return readLine
        }

        fun convertToNames(input: String): List<String> {
            return input.split(DELIMITER)
                .map(String::trim)
        }

        private fun convertToGameCount(input: String): Int {
            try {
                return input.trim().toInt()
            } catch (e: NumberFormatException) {
                throw InvalidInputException(EXCEPTION_MSG_GAME_COUNT)
            }
        }
    }
}
