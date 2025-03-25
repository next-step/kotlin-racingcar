package carracing.game.view

import carracing.game.domain.data.Race

class CarRacingView {
    fun printCurrentRaceState(race: Race) {
        println("Round ${race.round}")
        race.cars.forEach {
            println("-".repeat(it.position))
        }
    }
}
