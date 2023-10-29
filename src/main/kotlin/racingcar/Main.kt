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

    ResultView.printResult()

    val positions = gameRecorder.positionBoard
        .entries
        .map { it.value.positions }

    for (i in 0 until tryMoveCount) {
        for (j in positions.indices) {
            ResultView.printSkid(positions[j][i])
        }
        println()
    }
}
