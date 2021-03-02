package step3

fun main() {
    val (carNames, raceCount) = InputView.handleInput()

    val cars = Cars.fromNames(carNames)
    val racingGame = RacingGame(cars, RandomRule())

    val results = racingGame.play(raceCount)

    OutputView.handleOutput(raceCount, results)
}
