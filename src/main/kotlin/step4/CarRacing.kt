package step4

import step4.model.Race
import step4.model.Referee
import step4.strategy.ConditionalMoveStrategy
import step4.view.InputView
import step4.view.ResultView

fun main() {
    val nameListOfCars = InputView.getNameListOfCars()
    val numberOfTrials = InputView.getNumberOfTrials()

    val race = Race()

    race.initiate(numberOfTrials, nameListOfCars)
    race.start(ConditionalMoveStrategy())

    val carsAfterRace = race.getCars()
    val winner = Referee().getWinner(carsAfterRace)

    ResultView.output(numberOfTrials, carsAfterRace)
    ResultView.noticeWinner(winner)
}
