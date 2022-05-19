package racingcar

import kotlin.random.Random

data class Car(var defaultDistance: Int = 0) {
    var distance = defaultDistance
        private set

    fun moveRandom(number: Int = Random.nextInt(MAX_RANDOM_VALUE)) {
        if (canMove(number)) {
            distance += MOVE_FORWARD_VALUE
        }
    }

    private fun canMove(number: Int): Boolean =
        number >= MINIMUM_VALUE_FOR_MOVEMENT

    companion object {
        private const val MAX_RANDOM_VALUE = 10
        private const val MOVE_FORWARD_VALUE = 1
        private const val MINIMUM_VALUE_FOR_MOVEMENT = 4
    }
}
