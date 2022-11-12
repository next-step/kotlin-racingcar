package racingcar.ui

object InputView {

    private const val READ_LINE_CAR_NUM_INTRO_RESOURCE = "자동차 대수는 몇 대인가요?"
    private const val READ_LINE_EXECUTE_NUM_INTRO_RESOURCE = "시도할 횟수는 몇 회인가요?"

    fun requestCarNum(): Int {
        println(READ_LINE_CAR_NUM_INTRO_RESOURCE)
        return readInt("carNum")
    }

    fun requestExecuteNum(): Int {
        println(READ_LINE_EXECUTE_NUM_INTRO_RESOURCE)
        return readInt("executeNum")
    }

    private fun readInt(subject: String): Int =
        requireNotNull(readLine()?.toIntOrNull()) { "$subject must be Integer" }
            .also {
                check(it > 0) { "$subject must be more than 0" }
            }
}
