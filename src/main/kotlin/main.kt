import racing.game.RacingGame
import racing.view.InputView

fun main() {
    val input = InputView()
    val carCount = input.inputCarCount()
    val retryCount = input.inputRetryCount()

    val racingGame = RacingGame(carCount)

    racingGame.executeGame(retryCount, racingGame.cars)
}
