package racing.controller

import racing.CarFactory
import racing.RacingManager
import racing.domain.Car
import racing.view.InputView
import racing.view.ResultView

class RacingController(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun racingGame() {

        val inputCarName = inputView.printInputCarNames()
        val cars = CarFactory().createCarsByInputCarName(inputCarName)
        val tryCount = inputView.printInputCount()

        resultView.printResult()
        carNameViewRacing(tryCount, cars)
        val winners = RacingManager().getRaceWinnerCars(cars)
        resultView.printWinnerNames(winners)
    }

    private fun carNameViewRacing(tryCount: Int, cars: List<Car>) {
        repeat(tryCount) {
            cars.forEach { car ->
                car.move()
                ResultView.printNameAndDistance(car)
            }
            resultView.printEnter()
        }
    }

    private fun carRacing(tryCount: Int, cars: List<Car>) {
        repeat(tryCount) {
            cars.forEach { car ->
                car.move()
                resultView.printDistance(car.position)
            }
            resultView.printEnter()
        }
    }
}
