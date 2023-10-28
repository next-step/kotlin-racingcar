package game

class RacingCarGame() {

    fun start() {
        val carCount = UserInputHandler.askForCarCount()
        val retryCount = UserInputHandler.askForRetryCount()
        val cars = Cars.fromCarCount(carCount, RandomMoveConditionGenerator())
        cars.advance(retryCount, UserMessageDisplay::display)
    }
}

fun main() {
    val racingCarGame = RacingCarGame()
    racingCarGame.start()
}
