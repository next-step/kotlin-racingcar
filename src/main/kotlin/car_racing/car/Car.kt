package car_racing.car

import car_racing.move.Move
import car_racing.move.RandomMove

class Car(
    private val tryNumber: Int,
    private val moveFun: Move = RandomMove(),
    position: Int = 0
) {
    var position: Int = position
        private set

    var currentStage: Int = 0
        private set

    val moveHistory: MutableList<Int> = MutableList(tryNumber) { 0 }

    fun move() {
        when (moveFun.isMove()) {
            true -> moveHistory[currentStage] = ++position
            false -> moveHistory[currentStage] = position
        }
        currentStage += 1
    }
}
