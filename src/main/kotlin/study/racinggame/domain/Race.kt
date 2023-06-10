package study.racinggame.domain

import study.racinggame.race.RaceRule
import study.racinggame.race.view.DrawView
import study.racinggame.race.view.InputView

class Race(
    private val inputView: InputView,
    private val raceRule: RaceRule
) {

    private var carStorage: List<Car> = inputView.carNames()
        .map { carName -> Car(name = carName) }
    private val drawView: DrawView = DrawView()

    fun startRace() {
        repeat(inputView.raceTryCnt()) {
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
