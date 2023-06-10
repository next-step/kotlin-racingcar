package study.racinggame.domain

import study.racinggame.race.RaceRule

class Race(
    private val carStorage: List<Car>,
    private val raceRule: RaceRule
) {

    fun runTrack(): List<CarResponse> {
        moveCarsIfPossible()
        return carStorage.map(CarResponse.Companion::of)
    }

    fun getRaceWinner(): String {
        val maxValue: Int = carStorage.maxOf { each -> each.position() }
        return carStorage.filter { each -> each.position() == maxValue }
            .joinToString(", ") { winner -> winner.name }
    }

    fun carStorage() = carStorage

    private fun moveCarsIfPossible() {
        for (car in carStorage) {
            car.moveForward(raceRule.canMove())
        }
    }
}
