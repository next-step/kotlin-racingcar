package racing

import racing.domain.Car
import racing.generator.DefaultRandomNumberGenerator
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
                val randomNumber = DefaultRandomNumberGenerator().nextInt(10)
                val distance = moveAndStop(car, randomNumber)
                ResultView.printDistance(distance)
            }
            println()
        }
    }

    fun moveAndStop(car: Car, randomNumber: Int): String {
        if (car.moveCheck(randomNumber)) {
            car.move()
        }

        return "-".repeat(car.position)
    }
}
