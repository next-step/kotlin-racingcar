package racing

fun main() {
    val carNames = InputView.readCarNames()
    val tryCount = InputView.readTryCount()

    val cars = Cars.of(carNames)
    val randomMovePolicy = RandomMovePolicy()

    ResultView.printHeader()
    for (i in 0 until tryCount) {
        cars.play(randomMovePolicy)
        ResultView.printRacingResult(cars)
    }
}
