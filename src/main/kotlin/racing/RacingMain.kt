package racing

import racing.domain.Cars
import racing.domain.RacingGame
import racing.domain.RandomMovePolicy
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val carNames = InputView.readCarNames()
    val cars = Cars.of(carNames)

    val tryCount = InputView.readTryCount()

    val racingGame = RacingGame(cars, tryCount)
    val raceResult = racingGame.race(RandomMovePolicy())

    ResultView.printHeader()
    ResultView.printRacingResult(raceResult)
    ResultView.printWinners(raceResult.last().getWinners())
}
