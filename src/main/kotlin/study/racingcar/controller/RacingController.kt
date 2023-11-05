package study.racingcar.controller

import study.racingcar.domain.Cars
import study.racingcar.domain.DefaultRandomValueGenerator
import study.racingcar.domain.RacingGame
import study.racingcar.view.DefaultInputProvider
import study.racingcar.view.DefaultOutputReceiver
import study.racingcar.view.InputView
import study.racingcar.view.ResultView

class RacingController {
    private val inputView = InputView(DefaultInputProvider())
    private val resultView = ResultView(DefaultOutputReceiver())
    private val randomValueGenerator = DefaultRandomValueGenerator()

    fun startRacing() {
        val carNames = inputView.getCarNames()
        val numberOfRounds = inputView.getNumberOfRounds()

        val racingGame = RacingGame(carNames, numberOfRounds, randomValueGenerator)

        resultView.startDisplayResult()
        racingGame.raceStart { cars ->
            resultView.displayRound(convertCarsToList(cars))
        }
        resultView.displayWinners(racingGame.getWinners().list.map { it.name })
    }

    private fun convertCarsToList(cars: Cars): List<Pair<String, Int>> {
        return cars.list.map { car -> Pair(car.name, car.position) }
    }
}
