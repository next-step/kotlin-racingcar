package study.step3.ui

import study.step3.domain.Car

object ResultView {
    fun displayCars(cars: List<Car>) {
        println("실행 결과")
        cars.forEach { car ->
            displayPosition(car)
        }
        println()
    }

    private fun displayPosition(car: Car): String {
        return "-".repeat(car.getPosition())
    }
}
