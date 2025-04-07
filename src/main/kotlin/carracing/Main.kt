package carracing

import carracing.view.InputView.getCarNames
import carracing.view.InputView.getRoundInput

fun main() {
    val carsInput =
        getCarNames(promptQuestion = "Enter the names of the cars (separated by commas):")
    val numRounds = getRoundInput(promptQuestion = "How many rounds will be played?")

    val cars = CarGenerator.generateCars(carsInput)
    val race = CarRace(cars = cars, numRounds = numRounds)

    race.startRace()

}
