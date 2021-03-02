package racingcar.utils

import racingcar.dto.InputDto
import racingcar.exception.InvalidInputException

private const val QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val QUESTION_FOR_GAME_COUNT = "시도할 횟수는 몇 회인가요?"
private const val DELIMITER = ","

class InputUtils {
    companion object {
        fun askQuestions(): InputDto {
            println(QUESTION_FOR_CAR_NAMES)
            var readCarNames = readLine()
            while (readCarNames.isNullOrBlank()) {
                println(QUESTION_FOR_CAR_NAMES)
                readCarNames = readLine()
            }
            val carCount = convertToNames(readCarNames!!)

            println(QUESTION_FOR_GAME_COUNT)
            var readGameCount = readLine()
            while (readGameCount.isNullOrBlank()) {
                println(QUESTION_FOR_GAME_COUNT)
                readGameCount = readLine()
            }
            val gameCount = convertToGameCount(readGameCount!!)

            return InputDto(carCount, gameCount)
        }

        fun convertToNames(input: String): List<String> {
            return input.split(DELIMITER)
                .map(String::trim)
        }

        private fun convertToGameCount(input: String): Int {
            try {
                return input!!.trim().toInt()
            } catch (e: NumberFormatException) {
                throw InvalidInputException("게임 횟수는 숫자만 입력 가능합니다.")
            }
        }
    }
}
