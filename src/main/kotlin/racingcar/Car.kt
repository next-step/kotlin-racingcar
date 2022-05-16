package racingcar

import kotlin.random.Random

data class Car(var distance: Int = 0) {

    fun moveRandom(number: Int = Random.nextInt(Companion.MAX_RANDOM_VALUE)) {
        if (canMove(number)) {
            distance += 1
        }
    }

    private fun canMove(number: Int): Boolean {
        if (number >= 4) {
            return true
        }

        return false
    }

    companion object {
        const val MAX_RANDOM_VALUE = 10
    }
}
