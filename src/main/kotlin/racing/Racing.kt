package racing

import racing.domain.Car
import racing.generator.DefaultRandomMoveCheckGenerator
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

    fun createCars(carCount: Int): List<Car> = (0 until carCount).map { Car(moveFlag = DefaultRandomMoveCheckGenerator()) }

    private fun carRacing(tryCount: Int, cars: List<Car>) {
        repeat(tryCount) {
            cars.forEach { car ->
                val distance = moveAndStop(car)
                ResultView.printDistance(distance)
            }
            ResultView.printEnter()
        }
    }

    fun moveAndStop(car: Car): String {
        if (car.moveCheck()) {
            car.move()
        }

        return "-".repeat(car.position)
    }
}
