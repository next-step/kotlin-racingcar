package racing.domain

import racing.generator.RandomGenerator

class Car(
    val moveFlag: RandomGenerator
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

    private fun moveCheck(): Boolean = this.moveFlag.getRandomNumber(10) >= 4
}
