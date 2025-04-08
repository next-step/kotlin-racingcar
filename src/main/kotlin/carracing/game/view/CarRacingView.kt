package carracing.game.view

import carracing.game.domain.data.Race

class CarRacingView {
    fun printCurrentRaceState(race: Race) {
        println("\nRound ${race.round}")
        race.cars.forEach {
            println(it.toString())
        }
    }

    fun printWinners(winnerNames: List<String>) {
        println("\uD83C\uDFC6 Winners: ${winnerNames.joinToString()} \uD83C\uDFC6")
    }
}
