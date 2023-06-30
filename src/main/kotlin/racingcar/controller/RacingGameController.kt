package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGameParam
import racingcar.io.InputView
import racingcar.io.ResultView
import racingcar.util.RandomNumberGenerator

object RacingGameController {

    fun start() {
        val gameParam = getGameParam()
        val cars: Cars = Cars.createCars(gameParam.carNameList, RandomNumberGenerator)
        ResultView.printResultMessage()
        repeat(gameParam.rounds) {
            runRound(cars)
        }
        ResultView.printWinners(getWinners(cars))
    }

    private fun getGameParam(): RacingGameParam {
        val carNameList = InputView.getCarNames()
        val rounds = InputView.getRoundCount()
        return RacingGameParam(carNameList, rounds)
    }

    private fun runRound(cars: Cars) {
        cars.moveAll()
        ResultView.printRound(cars)
    }

    private fun getWinners(cars: Cars): List<Car> = cars.getWinners()
}
