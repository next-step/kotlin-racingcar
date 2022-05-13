package step3

object RaceRunner {
    @JvmStatic
    fun main(args: Array<String>) {
        run()
    }

    fun run() {
        val numCars = InputView.getNumCars()
        val numTries = InputView.getNumTries()
        var race = Race(numCars, numTries)
        OutputView.printRace(race)
        while (!race.isFinished()) {
            race = race.next()
            OutputView.printRace(race)
        }
    }
}
