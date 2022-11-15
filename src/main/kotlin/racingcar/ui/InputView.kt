package racingcar.ui

object InputView {

    private const val CAR_NUM_INTRO_RESOURCE = "자동차 대수는 몇 대인가요?"
    private const val CAR_NAME_INTRO_RESOURCE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val EXECUTE_NUM_INTRO_RESOURCE = "시도할 횟수는 몇 회인가요?"

    fun requestCarNum(): Int {
        println(CAR_NUM_INTRO_RESOURCE)
        return readInt("carNum")
    }

    fun requestCarNames(): List<String> {
        println(CAR_NAME_INTRO_RESOURCE)
        return readString("carName").split(",")
    }

    fun requestExecuteNum(): Int {
        println(EXECUTE_NUM_INTRO_RESOURCE)
        return readInt("executeNum")
    }

    private fun readInt(subject: String): Int =
        requireNotNull(readLine()?.toIntOrNull()) { "$subject must be Integer" }
            .also {
                check(it > 0) { "$subject must be more than 0" }
            }

    private fun readString(subject: String): String =
        requireNotNull(readLine()) { "$subject must be non-null" }
}
