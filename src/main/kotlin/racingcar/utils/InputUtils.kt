package racingcar.utils

import racingcar.view.InputView

const val QUESTION_FOR_CAR_COUNT = "자동차 대수는 몇 대인가요?"
const val QUESTION_FOR_GAME_COUNT = "시도할 횟수는 몇 회인가요?"

class InputUtils {
    companion object {
        fun askQuestions(): InputView {
            println(QUESTION_FOR_CAR_COUNT)
            val carCount = readLine()!!.toString().trim().toInt()

            println(QUESTION_FOR_GAME_COUNT)
            val gameCount = readLine()!!.toString().trim().toInt()

            return InputView(carCount, gameCount)
        }
    }
}
