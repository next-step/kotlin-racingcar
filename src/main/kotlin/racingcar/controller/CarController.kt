package racingcar.controller

import racingcar.model.CarName
import racingcar.model.CarsFactory
import racingcar.model.Race
import racingcar.model.creator.CarCreator
import racingcar.view.InputView
import racingcar.view.OutputView

class CarController(
    private val carCreator: CarCreator,
) {
    fun run() {
        OutputView.printQuestionCarName()
        val carNames = InputView.inputNames().map { CarName(it) }
        OutputView.printQuestionTryCount()
        val tryCount = InputView.inputNumber()
        val cars = CarsFactory.createCars(carCreator, carNames)
        val race = Race(tryCount = tryCount, cars = cars)

        race.start()
        OutputView.printRoundResult(race.getRoundResults())
        OutputView.printWinners(race.getWinners())
    }
}
