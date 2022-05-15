package racingCar

class RaceGame(private val inputView: InputView, private val resultView: ResultView) {
    fun start() {
        val carCount = inputView.askCarCount()
        val tryCount = inputView.askTryCount()

        val race = Race(carCount, tryCount)

        race.run()

        resultView.show(race.carPositions)
    }
}