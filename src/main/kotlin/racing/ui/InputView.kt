package racing.ui

private const val INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대인가요?"
private const val INPUT_COUNT_OF_TRY_MESSAGE = "시도할 횟수는 몇 회인가요?"

object InputView {

    fun inputNumberOfCars(): Int {
        println(INPUT_NUMBER_OF_CARS_MESSAGE)
        return readLine()!!.toInt()
    }

    fun inputCountOfTry(): Int {
        println(INPUT_COUNT_OF_TRY_MESSAGE)
        return readLine()!!.toInt()
    }
}
