package presentation.view

import domain.Race

class ResultView {

    private val inputView = InputView()
    private lateinit var race: Race

    fun result() {
        inputView.inputCarCount()
        inputView.inputRetryRetryCount()
        race = Race(inputView.getCarList())
        repeat(inputView.getRetryCount()) {
            inputView.getCarList().map {
                race.moveCar()
                println("-".repeat(it.position))
            }
            println()
        }
    }
}
