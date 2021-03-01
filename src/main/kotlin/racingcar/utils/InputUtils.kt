package racingcar.utils

import racingcar.dto.InputDto

private const val QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val QUESTION_FOR_GAME_COUNT = "시도할 횟수는 몇 회인가요?"
private const val DELIMITER = ","

class InputUtils {
    companion object {
        fun askQuestions(): InputDto {
            println(QUESTION_FOR_CAR_NAMES)
            val readLine = readLine()
            val carCount = convertToNames(readLine)

            println(QUESTION_FOR_GAME_COUNT)
            val gameCount = readLine()!!.trim().toInt()

            return InputDto(carCount, gameCount)
        }

        fun convertToNames(readLine: String?): List<String> {
            return readLine!!.split(DELIMITER)
                .map(String::trim)
                .toList()
        }
    }
}
