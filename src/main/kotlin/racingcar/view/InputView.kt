package racingcar.view

object InputView {
    private const val ASK_NUMBER_CARS_MESSAGE = "자동차 대수는 몇 대인가요?"
    private const val ASK_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?"

    fun readNumberCars() {
        println(ASK_NUMBER_CARS_MESSAGE)
    }

    fun readTryCount() {
        println(ASK_TRY_COUNT_MESSAGE)
    }
}
