import racing.car.RacingCars
import racing.game.RacingGame
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val input = InputView()
    val carName = input.inputCarName()
    val retryCount = input.inputRetryCount()

    val racingGame = RacingGame(carName)
    val racingCars = RacingCars(racingGame.cars.racingCars)

    racingGame.executeGame(retryCount, racingGame.cars)
    val winners = racingCars.findWinner(racingGame.cars)

    ResultView().showWinner(winners)
}
