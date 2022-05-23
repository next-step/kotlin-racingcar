package racingcar.view

import racingcar.count.CarCount
import racingcar.count.MoveCount

class InputView(private val minCarCount: Int, private val minMoveCount: Int) {
    val carCount = getCarCount()
    val moveCount = getMoveCount()

    private fun getCarCount(askCount: Int = 1): CarCount = try {
        printBy(askCount)
        println(CarCount.inputMessage)
        CarCount(readln().toIntOrNull() ?: 0, minCarCount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getCarCount(askCount + 1)
    }

    private fun getMoveCount(askCount: Int = 1): MoveCount = try {
        printBy(askCount)
        println(MoveCount.inputMessage)
        MoveCount(readln().toIntOrNull() ?: 0, minMoveCount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getMoveCount(askCount + 1)
    }

    companion object {
        fun printBy(askCount: Int) {
            if (askCount % 4 == 0) println("같은걸 $askCount 번째 물어봅니다... s(^_^)a")
        }
    }
}
