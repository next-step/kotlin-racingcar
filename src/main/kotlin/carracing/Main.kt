package carracing

import carracing.view.InputView

fun main() {
    val numCars = InputView.getInput(promptQuestion = "How many cars are in the race?")
    val numRounds = InputView.getInput(promptQuestion = "How many rounds will be played?")

    val cars = CarGenerator.generateCars(numCars)
    val race = CarRace(cars = cars, numRounds = numRounds)

    race.startRace()

}
