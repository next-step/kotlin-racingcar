package next.step.racing.service

import next.step.racing.domain.InputCount

object InputDevice {
    private const val ENTER_CAR_COUNT = "자동차 대수는 몇 대인가요?"
    private const val ENTER_STEP_COUNT = "시도할 횟수는 몇 회인가요?"
    private const val INVALID_CMD_MSG = "잘못된 명령어 입니다."
    fun readCarCount(): InputCount = read(ENTER_CAR_COUNT)
    fun readStepCount(): InputCount = read(ENTER_STEP_COUNT)

    fun read(enterMsg: String): InputCount {
        return try {
            println(enterMsg)
            InputCount.from(readln())
        } catch (e: Exception) {
            println(INVALID_CMD_MSG)
            read(enterMsg)
        }
    }
}
