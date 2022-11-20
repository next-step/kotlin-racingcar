package racingcar

fun main() {
    val cars = InputView.readCars()
    val roundCount = InputView.readRoundCount()

    val racingGame = RacingGame(
        cars = cars,
        numberGenerator = RacingCarNumberGenerator()
    )

    repeat(roundCount) {
        val drivingCars = racingGame.round()
        ResultView.printLocation(drivingCars)
    }

    val winners = racingGame.judge()
    ResultView.printWinner(winners)
}
