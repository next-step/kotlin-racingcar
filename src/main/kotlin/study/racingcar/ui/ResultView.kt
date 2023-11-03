package study.racingcar.ui

import study.racingcar.domain.Race
import study.racingcar.dto.RacingCarState

object ResultView {
    fun displayCars(cars: List<RacingCarState>) {
        println("실행 결과")
        cars.forEach { car ->
            println("${car.name} : ${displayPosition(car)}")
        }
        println()
    }

    fun displayWinners(race: Race) {
        val winners = race.getWinners().joinToString { it.name }
        println("최종 우승자: $winners")
    }

    private fun displayPosition(car: RacingCarState): String {
        return "-".repeat(car.position)
    }
}
