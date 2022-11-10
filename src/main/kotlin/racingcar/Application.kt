package racingcar

fun main() {
    try {
        val carRacing = CarRacing(createCarRacers())

        carRacing.start(InputView.readTryCount())

        OutputView.writeResult(carRacing.result())
    } catch (e: RuntimeException) {
        OutputView.writeError(e)
    }
}

fun createCarRacers(): List<CarRacer> =
    IntRange(1, InputView.readCarCount()).map { CarRacer(StandardCar(), RandomCarControl()) }
