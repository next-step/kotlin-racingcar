package step3

fun main() {
    val (carNames, lapCount) = InputView.handleInput()

    val cars = Cars.fromNames(carNames)
    val racingGame = RacingGame(cars, RandomRule())

    val results = racingGame.play(lapCount)

    OutputView.handleOutput(lapCount, results)
}
