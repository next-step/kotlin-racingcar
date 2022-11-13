package racingcar

class Application

fun main() {
    val (cars, roundCount) = InputView()
    val racingGame = RacingGame(
        cars = cars,
        numberGenerator = RacingCarNumberGenerator()
    )

    repeat(roundCount) {
        val drivingCars = racingGame.round()
        ResultView.print(drivingCars)
    }
}
