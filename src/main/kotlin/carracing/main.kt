package carracing

fun main() {
    val numCars = InputView.getInput(promptQuestion = "How many cars are in the race?")
    val numRounds = InputView.getInput(promptQuestion = "How many rounds will be played?")

    val race = CarRace(numCars = numCars, numRounds = numRounds)
    race.startRace()
}
