package racingcar.car

import racingcar.move.Move
import racingcar.move.RandomMove

class Car(
    val moveHistory: MoveHistory = MoveHistory(tryNumber = 5),
    private val moveFun: Move = RandomMove(),
    position: Int = 0
) {
    var position: Int = position
        private set

    fun move() {
        when (moveFun.isMove()) {
            true -> moveHistory.record(++position)
            false -> moveHistory.record(position)
        }
    }

    class MoveHistory (private val tryNumber: Int) {
        val movements: MutableList<Int> = MutableList(tryNumber) { 0 }
        var currentStage: Int = 0
            private set

        fun record(position: Int) {
            movements[currentStage] = position
            currentStage += 1
        }
    }
}
