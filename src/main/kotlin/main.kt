import racing.game.RacingGame
import racing.view.InputView

fun main() {
    val input = InputView()
    val carName = input.inputCarName()
    val retryCount = input.inputRetryCount()

    val racingGame = RacingGame(carName)

    racingGame.executeGame(retryCount, racingGame.cars)
    racingGame.findWinner(racingGame.cars)
}
