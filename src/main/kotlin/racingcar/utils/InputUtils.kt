package racingcar.utils

import racingcar.dto.InputDto
import racingcar.exception.InvalidInputException

private const val QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val QUESTION_FOR_GAME_COUNT = "시도할 횟수는 몇 회인가요?"
private const val DELIMITER = ","
private const val ZERO_GAME_COUNT = 0

class InputUtils {
    companion object {
        fun askQuestions(): InputDto {
            println(QUESTION_FOR_CAR_NAMES)
            val carCount = convertToNames(readLine())

            println(QUESTION_FOR_GAME_COUNT)
            val gameCount = convertToGameCount(readLine())

            return InputDto(carCount, gameCount)
        }

        fun convertToNames(input: String?): List<String> {
            validateBlankInput(input)
            return input!!.split(DELIMITER)
                .map(String::trim)
                .toList()
        }

        private fun convertToGameCount(input: String?): Int {
            try {
                return input!!.trim().toInt()
            } catch (e: NumberFormatException) {
                throw InvalidInputException("게임 횟수는 숫자만 입력 가능합니다.")
            }
        }

        private fun validateBlankInput(input: String?) {
            if (input!!.isBlank()) {
                throw InvalidInputException("하나 이상의 차량 이름을 입력하세요")
            }
        }
    }
}
