package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Distance
import racingcar.domain.Name
import racingcar.domain.RacingGame
import racingcar.domain.TryCount
import racingcar.domain.Winner
import racingcar.domain.strategy.RandomForwardStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarController() {
    fun run() {
        val racingGame = initRacingGame()

        ResultView.printResultTitle()
        racingGame.start()

        val winners = Winner.from(racingGame.getCars())
        ResultView.printResult(racingGame.getCarRecords())
        ResultView.printWinners(winners)
    }

    private fun initRacingGame(): RacingGame {
        val nameOfCars = InputView.getNameOfCars()
        val tryCount = TryCount.from(InputView.getTryCount())
        val strategy = RandomForwardStrategy()
        val cars = Cars(
            nameOfCars.map {
                Car(name = Name(it), strategy = strategy, Distance())
            }
        )

        return RacingGame(
            cars = cars,
            tryCount = tryCount
        )
    }
}
