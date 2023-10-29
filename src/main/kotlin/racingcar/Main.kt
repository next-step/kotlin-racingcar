package racingcar

fun main() {
    val tryMoveCount = InputView.getTryMoveCount()

    val cars = InputView.getCars()

    val moveCondition = CarMoveCondition {
        (0..10).random()
    }

    val gameRecorder = RacingGameRecorder()

    RacingGame().play(cars, tryMoveCount, moveCondition, gameRecorder)

    val gameResult = gameRecorder.gameResultRecord

    ResultView.printGameResult(gameResult)
}
