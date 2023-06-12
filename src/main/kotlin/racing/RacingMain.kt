package racing

fun main() {
    val carCount = InputView.readCarCount()
    val tryCount = InputView.readTryCount()

    val cars = Cars.of(carCount)
    val randomMovePolicy = RandomMovePolicy()

    ResultView.printHeader()
    for (i in 0 until tryCount) {
        cars.play(randomMovePolicy)
        ResultView.printRacingResult(cars)
    }
}
