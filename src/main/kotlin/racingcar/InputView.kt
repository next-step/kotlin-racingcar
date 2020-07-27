package racingcar

object InputView {
    private const val ENTER_CAR_COUNT = "자동차 대수는 몇 대인가요?"
    private const val ENTER_CHANCE_TO_RUN = "시도할 횟수는 몇 회인가요?"

    fun getCarCnt(): Int {
        println(ENTER_CAR_COUNT)
        return readLine()!!.toInt()
    }

    fun getChanceToRun(): Int {
        println(ENTER_CHANCE_TO_RUN)
        return readLine()!!.toInt()
    }
}
