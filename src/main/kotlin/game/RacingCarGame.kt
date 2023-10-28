package game

class RacingCarGame(
    private val userInputHandler: UserInputHandler = ConsoleInputHandler(),
    private val userOutputHandler: UserOutputHandler = UserMessageDisplay(),
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator()
) {

    fun start() {
        val carCount = userInputHandler.askForCarCount()
        val retryCount = userInputHandler.askForRetryCount()
        val cars = Cars.fromCarCount(carCount, moveConditionGenerator)
        cars.advance(retryCount, userOutputHandler::display)
    }
}

fun main() {
    val racingCarGame = RacingCarGame()
    racingCarGame.start()
}
