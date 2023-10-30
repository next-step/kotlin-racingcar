package study.racingcar.ui

import study.racingcar.domain.Car

object ResultView {
    fun displayCars(cars: List<Car>) {
        println("실행 결과")
        cars.forEach { car ->
            println("${car.name} : ${displayPosition(car)}")
        }
        println()
    }

    private fun displayPosition(car: Car): String {
        return "-".repeat(car.position)
    }
}
