package step3.ui

object InputView {

    private const val READ_LINE_CAR_NUM_INTRO_RESOURCE = "자동차 대수는 몇 대인가요?"
    private const val READ_LINE_EXECUTE_NUM_INTRO_RESOURCE = "시도할 횟수는 몇 회인가요?"

    fun requestCarNum(): Int {
        println(READ_LINE_CAR_NUM_INTRO_RESOURCE)
        val carNum = requireNotNull(readLine()) { "carNum must be not null" }.toIntOrNull()
        carNum.also {
            checkNotNull(it) { "carNum must be Integer" }
            check(it > 0) { "number of cars must be more than 0" }
        }
        return carNum!!
    }

    fun requestExecuteNum(): Int {
        println(READ_LINE_EXECUTE_NUM_INTRO_RESOURCE)
        val executeNum = requireNotNull(readLine()) { "executeNum must be not null" }.toIntOrNull()
        executeNum.also {
            checkNotNull(it) { "executeNum must be Integer" }
            check(it > 0) { "number of executions must be more than 0" }
        }
        return executeNum!!
    }
}
