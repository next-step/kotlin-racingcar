package racing

fun main() {
    val carNames = InputView.readCarNames()
    val cars = Cars.of(carNames)

    val tryCount = InputView.readTryCount()
    val racingGame = RacingGame(cars)
    val randomMovePolicy = RandomMovePolicy()
    val raceResult = racingGame.race(tryCount, randomMovePolicy)

    ResultView.printHeader()
    ResultView.printRacingResult(raceResult)
    ResultView.printWinners(raceResult.last())
}
