package study.racingcar.ui

import study.racingcar.domain.Car
import study.racingcar.dto.RacingCarState

object ResultView {
    fun displayCars(cars: List<RacingCarState>) {
        println("실행 결과")
        cars.forEach { car ->
            println("${car.name} : ${displayPosition(car)}")
        }
        println()
    }

    fun displayWinners(cars: List<RacingCarState>) {
        val maxPosition = cars.maxByOrNull { it.position }?.position ?: 0
        val winners = cars.filter { it.position == maxPosition }.joinToString { it.name }
        println("최종 우승자: $winners")
    }

    private fun displayPosition(car: RacingCarState): String {
        return "-".repeat(car.position)
    }
}
