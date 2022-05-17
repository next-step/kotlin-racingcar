package racingCar

object RaceGame {
    fun start() {
        val carCount = InputView.askCarCount()
        val tryCount = InputView.askTryCount()

        val race = Race(carCount)

        race.run()

        repeat(tryCount) {
            race.run()
            ResultView.show(race.result)
        }
    }
}
