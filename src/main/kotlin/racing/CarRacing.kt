package racing

import racing.model.Race
import racing.model.Referee
import racing.strategy.ConditionalMoveStrategy
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val nameListOfCars = InputView.getNameListOfCars()
    val numberOfTrials = InputView.getNumberOfTrials()

    val race = Race()

    race.initiate(numberOfTrials, nameListOfCars)
    race.run(ConditionalMoveStrategy())

    val carsAfterRace = race.getCars()
    val winner = Referee().getWinner(carsAfterRace)

    ResultView.output(numberOfTrials, carsAfterRace)
    ResultView.noticeWinner(winner)
}
