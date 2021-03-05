package study.racingcar.controller

import study.racingcar.domain.Car
import study.racingcar.domain.CarNameParser
import study.racingcar.domain.RacingGame
import study.racingcar.domain.RandomMoveCarStrategy
import study.racingcar.domain.Winner
import study.racingcar.view.InputView
import study.racingcar.view.ResultView

fun main() {
    val carNames: String = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()

    val cars: List<Car> = CarNameParser.requestParseCarNames(carNames)
    val racingGame = RacingGame(RandomMoveCarStrategy())

    val resultCars: List<Car> = startGame(tryCount, racingGame, cars)
    outputWinner(resultCars)
}

private fun startGame(
    tryCount: Int,
    racingGame: RacingGame,
    cars: List<Car>
): List<Car> {
    ResultView.outputResultString()

    var resultCars: List<Car> = emptyList()
    for (i in 0 until tryCount) {
        resultCars = racingGame.raceCars(cars)
        ResultView.outputResult(resultCars)
    }
    return resultCars
}

private fun outputWinner(resultCars: List<Car>) {
    val winners = Winner().fetchWinners(resultCars)
    ResultView.outputWinner(winners)
}
