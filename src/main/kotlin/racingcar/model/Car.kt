package racingcar.model

import racingcar.model.movement.Movement

class Car(val carId: String, private val movement: Movement, val carName: String = carId) {

    var position: Int = 0
        private set

    fun moveIfItCan() {
        if (this.movement.canMoveNow()) {
            this.moveOneStep()
        }
    }

    fun reset() {
        this.position = 0
    }

    private fun moveOneStep() = (++this.position)
}
