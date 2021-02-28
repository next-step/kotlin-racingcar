package step3

fun main() {
    val (carCount, raceCount) = InputView.handleInput()

    val cars = Car.makeCars(carCount)
    val racingGame = RacingGame(cars, Rule(), raceCount)

    val results = racingGame.play()

    OutputView.handleOutput(raceCount, results)
}
