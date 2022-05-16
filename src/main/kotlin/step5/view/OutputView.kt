package step5.view

import step5.model.Car
import step5.model.Race

object OutputView {
    fun printRace(race: Race) {
        race.cars.forEach {
            println(formatPosition(it))
        }
        println()
    }

    fun formatPosition(car: Car): String {
        return "${car.name}: " + "-".repeat(car.position)
    }

    fun printWinner(race: Race) {
        val winners = race
            .getWinner()
            .map { it.name }
            .joinToString(", ")
        println("$winners 가 최종 우승했습니다.")
    }
}
