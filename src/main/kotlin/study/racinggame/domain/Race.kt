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

            drawView.drawCarState(carResponses)
        }
    }

    fun noticeRaceWinner() {
        val maxValue: Int = carStorage.maxOf { each -> each.position() }

        val winnerName: String = carStorage.filter { each -> each.position() == maxValue }
            .joinToString(", ") { winner -> winner.name }

        drawView.drawRaceWinner(winnerName)
    }

    fun carStorage() = carStorage

    private fun moveCarsIfPossible() {
        for (car in carStorage) {
            car.moveForward(raceRule.canMove())
        }
    }
}
