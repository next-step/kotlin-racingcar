package racingcar.view

import racingcar.count.CarCount
import racingcar.count.MoveCount

class InputView(private val minCarCount: Int, private val minMoveCount: Int) {
    val carCount = getCarCount()
    val moveCount = getMoveCount()

    private fun getCarCount(retry: Int = 1): CarCount = try {
        println("자동차 대수는 몇 대인가요?")
        CarCount(readln().toIntOrNull() ?: 0, minCarCount)
    } catch (e: Exception) {
        if (retry > 2) println("좋은 말로 할 때... s(^_^)b ")
        println(e.message)
        getCarCount(retry + 1)
    }

    private fun getMoveCount(retry: Int = 1): MoveCount = try {
        println("시도할 횟수는 몇 회인가요?")
        MoveCount(readln().toIntOrNull() ?: 0, minMoveCount)
    } catch (e: Exception) {
        if (retry > 2) println("좋은 말로 할 때... s(^_^)b ")
        println(e.message)
        getMoveCount(retry + 1)
    }
}
