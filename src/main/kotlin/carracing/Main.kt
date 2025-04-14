package carracing

import carracing.view.InputView.getCarNames
import carracing.view.InputView.getRoundInput
import carracing.view.ResultView

fun main() {
    val carsInput =
        getCarNames(promptQuestion = "Enter the names of the cars (separated by commas):")
    val numRounds = getRoundInput(promptQuestion = "How many rounds will be played?")

    val cars = CarGenerator.generateCars(carsInput)
    val race = CarRace(cars = cars, numRounds = numRounds)
    val raceHistory: RaceHistory = race.startRace()
    raceHistory.forEach { _ -> ResultView.showStatus(cars) }
    ResultView.displayWinners(winners = race.getWinners())

}
