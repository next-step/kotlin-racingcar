package racingcar.controller

import racingcar.model.Cars
import racingcar.model.NaturalNumber.Companion.createNaturalNumber
import racingcar.model.creator.CarCreator
import racingcar.view.InputView
import racingcar.view.ResultView

class CarController(
    private val carCreator: CarCreator,
) {
    fun run() {
        println("자동차 대수는 몇 대 인가요?")
        val carCount = InputView.inputNumber()
        println("시도할 회수는 몇회인가요?")
        val tryCount = InputView.inputNumber()
        val cars = Cars(
            carCreator = carCreator,
            numberOfCar = createNaturalNumber(carCount),
        )
        println("\n실행 결과")

        repeat(createNaturalNumber(tryCount).number) {
            cars.move()
            ResultView.printResult(cars)
        }
    }
}
