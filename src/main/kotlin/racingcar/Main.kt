package racingcar

fun main() {
    val carCount = InputView.getCarCount()
    val tryMoveCount = InputView.getTryMoveCount()

    val cars = Array(carCount) { Car() }

    val game = RacingGame()
    val moveCondition = MinimumAboveNumberMoveCondition {
        (0..10).random()
    }

    game.play(cars, tryMoveCount, moveCondition)
}
