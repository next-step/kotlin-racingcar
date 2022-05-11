package racingcar.model

import racingcar.model.movement.Movement

class Car(private val movement: Movement) {

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
