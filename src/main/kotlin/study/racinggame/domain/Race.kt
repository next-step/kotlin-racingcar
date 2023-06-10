package study.racinggame.domain

import study.racinggame.race.RaceRule
import study.racinggame.race.view.DrawView
import study.racinggame.race.view.InputView

class Race(
    private val inputView: InputView,
    private val raceRule: RaceRule
) {

    private val carCount = inputView.carCount()
    private val carStorage = Array(carCount) { Car() }

    fun startRace() {
        {
            moveCarsIfPossible()
            val carResponses = carStorage.map(CarResponse.Companion::of)
            DrawView().drawCarState(carResponses)
        }.repeat(inputView.raceTryCnt())
    }

    fun carStorage() = carStorage

    private fun moveCarsIfPossible() {
        for (car in carStorage) {
            car.moveForward(raceRule.canMove())
        }
    }
}

fun (() -> Unit).repeat(n: Int) {
    require(n >= 0) { "Count 'n' must be non-negative, but was $n." }

    for (i in 0 until n) {
        this.invoke()
    }
}
