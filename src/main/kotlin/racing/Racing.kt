package racing

import racing.domain.Car
import racing.view.InputView
import racing.view.ResultView

class Racing {

    fun racingGame() {

        val inputCarName = InputView.printInputCarNames()

        ResultView.printResult()

        val cars = CarFactory().createCarsByInputCarName(inputCarName)
        val tryCount = InputView.printInputCount()
        carNameViewRacing(tryCount, cars)

        val winners = RacingManager().getRaceWinnerCars(cars)
        ResultView.printWinnerNames(winners)
    }

    private fun carNameViewRacing(tryCount: Int, cars: List<Car>) {
        repeat(tryCount) {
            cars.forEach { car ->
                car.move()
                ResultView.printNameAndDistance(car)
            }
            ResultView.printEnter()
        }
    }

    private fun carRacing(tryCount: Int, cars: List<Car>) {
        repeat(tryCount) {
            cars.forEach { car ->
                car.move()
                ResultView.printDistance(car.position)
            }
            ResultView.printEnter()
        }
    }
}
