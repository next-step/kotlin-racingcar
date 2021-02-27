package racingcar.utils

import racingcar.dto.InputDto

private const val QUESTION_FOR_CAR_COUNT = "자동차 대수는 몇 대인가요?"
private const val QUESTION_FOR_GAME_COUNT = "시도할 횟수는 몇 회인가요?"

class InputUtils {
    companion object {
        fun askQuestions(): InputDto {
            println(QUESTION_FOR_CAR_COUNT)
            val carCount = readLine()!!.trim().toInt()

            println(QUESTION_FOR_GAME_COUNT)
            val gameCount = readLine()!!.trim().toInt()

            return InputDto(carCount, gameCount)
        }
    }
}
