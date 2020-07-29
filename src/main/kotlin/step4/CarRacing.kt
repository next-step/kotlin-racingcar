package step4

import step4.model.Race
import step4.view.InputView
import step4.view.ResultView

fun main() {
    val nameListOfCars = InputView.getNameListOfCars()
    val numberOfTrials = InputView.getNumberOfTrials()

    val races = Race(nameListOfCars)

    repeat(numberOfTrials) {
        races.makeTurn()
    }

    val carsAfterRace = races.getCars()

    ResultView.output(numberOfTrials, carsAfterRace)
    ResultView.noticeWinner(carsAfterRace)
}
