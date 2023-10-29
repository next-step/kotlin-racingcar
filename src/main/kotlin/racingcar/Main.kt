package racingcar

fun main() {
    val carCount = InputView.getCarCount()
    val tryMoveCount = InputView.getTryMoveCount()

    val cars = Array(carCount) { Car() }.toList()

    val moveCondition = CarMoveCondition {
        (0..10).random()
    }

    val gameRecorder = RacingGameRecorder()

    RacingGame().play(cars, tryMoveCount, moveCondition, gameRecorder)

    val gameResult = gameRecorder.gameResultRecord

    ResultView.printGameResult(gameResult)
}
