package racingcar.controller

import racingcar.model.Cars
import racingcar.model.NaturalNumber.Companion.createNaturalNumber
import racingcar.model.creator.CarCreator
import racingcar.view.InputView
import racingcar.view.OutputView

class CarController(
    private val carCreator: CarCreator,
) {
    fun run() {
        OutputView.printQuestionCarNumber()
        val carCount = InputView.inputNumber()
        OutputView.printQuestionTryCount()
        val tryCount = InputView.inputNumber()

        val cars = Cars(
            carCreator = carCreator,
            numberOfCar = createNaturalNumber(carCount),
        )

        OutputView.printResultMessage()

        repeat(createNaturalNumber(tryCount).number) {
            cars.move()
            OutputView.printResult(cars.getCars())
        }
    }
}
