package racing.domain

import racing.generator.DefaultRandomMoveCheckGenerator

class Car(
    val moveFlag: DefaultRandomMoveCheckGenerator
) {

    var currentPosition: Int = 0
        private set

    val position: Int
        get() {
            if (moveCheck()) {
                currentPosition++
            }
            return currentPosition
        }

    private fun moveCheck(): Boolean = this.moveFlag.moveCheck(10)
}
