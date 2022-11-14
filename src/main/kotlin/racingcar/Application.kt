package racingcar

fun main() {
    try {
        val carRacing = CarRacing(carRacers = createCarRacers(), count = InputView.readTryCount())
        val raceResult = carRacing.result()

        OutputView.writeResult(raceResult)
    } catch (e: RuntimeException) {
        OutputView.writeError(e)
    }
}

private fun createCarRacers(): List<CarRacer> = InputView.readCarNames()
    .map { CarRacer(StandardCar(name = Name(it)), RandomCarControl()) }
