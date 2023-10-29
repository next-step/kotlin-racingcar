package game

class RacingCarGame(
    private val userInputHandler: UserInputHandler = ConsoleInputHandler(),
    private val userOutputHandler: UserOutputHandler = UserMessageDisplay(),
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator()
) {

    fun start() {
        val cars = getCars()
        val retryCount = getRetryCount()
        cars.let {
            it.advance(retryCount, moveConditionGenerator, userOutputHandler::display)
            userOutputHandler.displayWinners(it.findWinner())
        }
    }

    private fun getRetryCount(): Int =
        userInputHandler.askForRetryCount().let { InputValidator.validateCount(it); it.toInt() }

    private fun getCars(): CarFleet = userInputHandler.askForCarNames().let { CarNameParser.parse(it) }
        .let { CarNameValidator.validate(it); CarFleet.of(it) }
}
