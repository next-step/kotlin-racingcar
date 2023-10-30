package game.racing.view

object InputView {
    private const val HOW_MANY_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?"
    private const val HOW_MANY_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?"

    fun inputNumberOfCar(): Int {
        println(HOW_MANY_CAR_MESSAGE)
        return readln().toInt()
    }

    fun inputTryNumber(): Int {
        println(HOW_MANY_TRY_MESSAGE)
        return readln().toInt()
    }
}
