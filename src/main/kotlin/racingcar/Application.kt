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
        ResultView.print(drivingCars)
    }
}
