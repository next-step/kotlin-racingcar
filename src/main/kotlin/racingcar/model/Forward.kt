package racingcar.model

import kotlin.random.Random

class Forward {
    fun isForward(randomNumber: Int): Boolean {
        return randomNumber >= FORWARD_CONDITION
    }

    fun pickRandomNumberInRange(): Int {
        return Random.nextInt(0, 10)
    }

    companion object {
        private const val FORWARD_CONDITION = 4
    }
}
