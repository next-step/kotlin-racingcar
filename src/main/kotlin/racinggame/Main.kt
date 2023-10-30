package racinggame

fun main() {
    val carCount = InputView.getCarCount()
    val tryCount = InputView.getTryCount()

    val game = RacingGame(
        (1..carCount).map { Car() },
        tryCount,
        RandomDice()
    )

    val result = game.play()

    OutputView.printRacingResult(result)
}
