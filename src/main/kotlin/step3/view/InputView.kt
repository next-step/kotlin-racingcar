package step3.view

object InputView {

    private const val ENTER_CAR_COUNT: String = "자동차 대수는 몇 대인가요?"
    private const val ENTER_ROUND: String = "시도할 횟수는 몇 회인가요?"

    fun readStartInput(): RaceGameInput {
        println(message = ENTER_CAR_COUNT)
        val carCount = readln()

        println(message = ENTER_ROUND)
        val round = readln()

        return RaceGameInput(
            carCountInput = carCount,
            roundInput = round,
        )
    }
}
