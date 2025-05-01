package carracing.game.view

import carracing.game.domain.data.Car
import carracing.game.domain.data.NAME_MAX_LENGTH
import carracing.game.domain.data.Race

class CarRacingView {
    fun printCurrentRaceState(race: Race) {
        println("\nRound ${race.round}")
        race.cars.forEach {
            println(it.formatInfo())
        }
    }

    fun printWinners(winnerNames: List<String>) {
        println("\uD83C\uDFC6 Winners: ${winnerNames.joinToString()} \uD83C\uDFC6")
    }

    private fun Car.formatInfo() = "${name.padEnd(NAME_MAX_LENGTH)} : ${"-".repeat(position)}"
}
