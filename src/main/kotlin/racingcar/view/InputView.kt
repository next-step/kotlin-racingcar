package racingcar.view

import racingcar.count.CarNames
import racingcar.count.MoveCount

private fun printBy(askCount: Int) {
    if (askCount % 4 == 0) println("같은걸 $askCount 번째 물어봅니다... s(^_^)a")
}

class InputView(private val minCarCount: Int, private val minMoveCount: Int) {
    val carNames = getCarNames().value
    val moveCount = getMoveCount()

    private fun getCarNames(askCount: Int = 1): CarNames = try {
        printBy(askCount)
        println(CarNames.inputMessage)
        CarNames(readln(), minCarCount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getCarNames(askCount + 1)
    }

    private fun getMoveCount(askCount: Int = 1): MoveCount = try {
        printBy(askCount)
        println(MoveCount.inputMessage)
        MoveCount(readln().toIntOrNull() ?: 0, minMoveCount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getMoveCount(askCount + 1)
    }
}
