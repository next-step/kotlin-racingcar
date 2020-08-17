package racing

import racing.model.Race
import racing.model.Referee
import racing.strategy.ConditionalMoveStrategy
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val nameListOfCars = InputView.getNameListOfCars()
    val numberOfTrials = InputView.getNumberOfTrials()

    val race = Race(numberOfTrials, nameListOfCars)
    val strategy = ConditionalMoveStrategy()

    race.run(strategy)

    val carsAfterRace = race.cars
    val winner = Referee().getWinner(numberOfTrials, carsAfterRace)

    ResultView.output(numberOfTrials, carsAfterRace)
    ResultView.noticeWinner(winner)
}
