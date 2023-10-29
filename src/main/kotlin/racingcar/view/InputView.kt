package racingcar.view

object InputView {

    private const val CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?"
    private const val MOVE_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?"

    fun readCarCount(): Int {
        println(CAR_COUNT_QUESTION)
        return readln().toInt()
    }

    fun readTotalRound(): Int {
        println(MOVE_COUNT_QUESTION)
        return readln().toInt()
    }
}
