package racing

import racing.domain.Car
import racing.view.InputView
import racing.view.ResultView

class Racing {

    fun run() {

        val carCount = InputView.printInputCar()
        val tryCount = InputView.printInputCount()

        ResultView.printResult()

        val cars = createCars(carCount)
        carRacing(tryCount, cars)
    }

    fun createCars(carCount: Int): List<Car> = (0 until carCount).map { Car() }

    fun carRacing(tryCount: Int, cars: List<Car>) {
        repeat(tryCount) {
            for (car in cars) {
                moveAndStop(car)
            }
            println()
        }
    }

    private fun moveAndStop(car: Car) {
        if (car.moveCheck()) {
            car.move()
            val distance = "-".repeat(car.position)
            ResultView.printDistance(distance)
            return
        }

        if (car.position == 0) {
            println()
        } else {
            val distance = "-".repeat(car.position)
            ResultView.printDistance(distance)
        }
    }
}
