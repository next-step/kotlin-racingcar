package carracing.ui

import java.lang.IllegalArgumentException

const val INPUT_EXCEPTION_MESSAGE = "0 이상의 자연수를 입력해주세요"
const val INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
const val INPUT_ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"

object InputView {

    fun inputCarNames(): String {
        println(INPUT_CAR_MESSAGE)
        return readLine().toString()
    }

    fun getAttemptCount(): Int {
        println(INPUT_ATTEMPT_MESSAGE)
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException(INPUT_EXCEPTION_MESSAGE)
    }
}
