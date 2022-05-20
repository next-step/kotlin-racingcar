package step4

object RaceRunner {
    @JvmStatic
    fun main(args: Array<String>) {
        run()
    }

    fun run() {
        val cars = InputView.getCars()
        val numTries = InputView.getNumTries()
        var race = Race(cars, numTries)
        OutputView.printRace(race)
        while (!race.isFinished()) {
            race = race.next()
            OutputView.printRace(race)
        }
        OutputView.printWinner(race)
    }
}
