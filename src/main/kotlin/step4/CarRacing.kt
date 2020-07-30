package step4

import step4.model.Race
import step4.strategy.ConditionalMoveStrategy
import step4.view.InputView
import step4.view.ResultView

fun main() {
    val nameListOfCars = InputView.getNameListOfCars()
    val numberOfTrials = InputView.getNumberOfTrials()

    val race = Race(nameListOfCars)

    repeat(numberOfTrials) {
        race.makeTurn(ConditionalMoveStrategy())
    }

    val carsAfterRace = race.getCars()

    ResultView.output(numberOfTrials, carsAfterRace)
    ResultView.noticeWinner(carsAfterRace)
}
