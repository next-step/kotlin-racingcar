package racing.ui

import racing.domain.Car
import racing.domain.Cars

object OutputView {
    private const val DASH_LINE = "-"

    fun printTitle() = println("실행 결과")

    fun printCarNameAndPosition(cars: Cars) {
        cars.roundInfo.forEach {
            printCarLine(it)
        }
        println()
    }

    private fun printCarLine(car: Car) = println("${car.carName.name} : ${DASH_LINE.repeat(car.position.value)}")

    fun printWinnerCars(cars: List<Car>) {
        val winnerNames = cars.joinToString { it.carName.name }

        println("${winnerNames}가 최종 우승했습니다.")
    }
}
