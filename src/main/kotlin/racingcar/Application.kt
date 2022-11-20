package racingcar

fun main() {
    val roundCount = InputView.readRoundCount()
    val cars = InputView.readCars()

    val racingGame = RacingGame(
        cars = cars,
        numberGenerator = RacingCarNumberGenerator()
    )

    repeat(roundCount) {
        val drivingCars = racingGame.round()
        ResultView.print(drivingCars)
    }
}
