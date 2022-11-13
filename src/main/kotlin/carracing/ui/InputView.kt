package carracing.ui

import java.lang.IllegalArgumentException

const val INPUT_EXCEPTION_MESSAGE = "0 이상의 자연수를 입력해주세요"
const val INPUT_CAR_MESSAGE = "자동차 대수는 몇 대인가요?"
const val INPUT_ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"

object InputView {

    fun getCarCount(): Int {
        println(INPUT_CAR_MESSAGE)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(INPUT_EXCEPTION_MESSAGE)
    }

    fun getAttemptCount(): Int {
        println(INPUT_ATTEMPT_MESSAGE)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(INPUT_EXCEPTION_MESSAGE)
    }
}
