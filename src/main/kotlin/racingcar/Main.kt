package racingcar

fun main() {
    val cars = InputView.getCars()
    val tryMoveCount = InputView.getTryMoveCount()

    val moveCondition = CarMoveCondition {
        (0..10).random()
    }

    val gameRecorder = RacingGameRecorder()

    RacingGame().play(cars, tryMoveCount, moveCondition, gameRecorder)

    val gameResult = gameRecorder.gameResultRecord

    ResultView.printGameResult(gameResult)
}
