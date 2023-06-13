package step3.domain

import step3.view.OutputView
import step3.view.OutputView.printResult

class RacingGame(
    private val cars: List<Car>,
    private val totalTrialCount: Int
) {

    fun run() {
        printResult()

        repeat(totalTrialCount) {
            cars.forEach { car ->
                car.move()
            }
            OutputView.printPositionOfCars(cars)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }

        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }

    fun getCars(): List<Car> {
        return cars
    }
}
