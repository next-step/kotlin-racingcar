package racingcar.domain

import racingcar.domain.random.RandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

class CarRacing(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
    private val randomGenerator: RandomGenerator = RandomGenerator(),
    private val carFactory: CarFactory = CarFactory()
) {

    fun start() {

        val createCarNumber = inputView.inputNumberOfCars()
        val racingCount = inputView.inputNumberOfAttempts()

        val carList = carFactory.createCars(createCarNumber)

        for (i in 0 until racingCount) {
            for (car in carList) {
                car.forward(randomGenerator.getIntRandom())
            }
            resultView.action(carList)
            println()
        }
    }
}
