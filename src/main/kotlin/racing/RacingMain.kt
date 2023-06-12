package racing

fun main() {
    val carCount = InputView.readCarCount()
    val tryCount = InputView.readTryCount()

    val cars = Cars.of(carCount)

    ResultView.printHeader()
    for (i in 0 until tryCount) {
        cars.play(RandomMovePolicy())
        ResultView.printRacingResult(cars)
    }
}
