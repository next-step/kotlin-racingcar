package racingcar

fun main() {
    try {
        val carRacing = CarRacing(carRacers = createCarRacers(), count = InputView.readTryCount())

        OutputView.writeResult(carRacing.race())
        OutputView.writeWinner(Winner(carRacing))
    } catch (e: RuntimeException) {
        OutputView.writeError(e)
    }
}

private fun createCarRacers(): List<CarRacer> = InputView.readCarNames()
    .map { CarRacer(StandardCar(name = Name(it)), RandomCarControl()) }
