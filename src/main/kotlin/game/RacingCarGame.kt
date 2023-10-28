package game

class RacingCarGame(private val userInputHandler: UserInputHandler = ConsoleInputHandler()) {

    fun start() {
        val carCount = userInputHandler.askForCarCount()
        val retryCount = userInputHandler.askForRetryCount()
        val cars = Cars.fromCarCount(carCount, RandomMoveConditionGenerator())
        cars.advance(retryCount, UserMessageDisplay::display)
    }
}

fun main() {
    val racingCarGame = RacingCarGame()
    racingCarGame.start()
}
