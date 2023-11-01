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

    fun displayWinners(cars: List<Car>) {
        val maxPosition = cars.maxByOrNull { it.position }?.position ?: 0
        val winners = cars.filter { it.position == maxPosition }.joinToString { it.name.name }
        println("최종 우승자: $winners")
    }

    private fun displayPosition(car: Car): String {
        return "-".repeat(car.position)
    }
}
