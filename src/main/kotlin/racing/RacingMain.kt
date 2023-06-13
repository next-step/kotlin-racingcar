package racing

fun main() {
    val carNames = InputView.readCarNames()
    val cars = Cars.of(carNames)

    val tryCount = InputView.readTryCount()

    ResultView.printHeader()

    val randomMovePolicy = RandomMovePolicy()
    for (i in 0 until tryCount) {
        cars.play(randomMovePolicy)

        ResultView.printRacingResult(cars)
    }

    ResultView.printWinners(cars)
}
