package step3.domain

import java.util.Random

class Car {
    private val random = Random()
    var distance = 0

    fun forward() {
        if (random.nextInt(MAX_RANDOM) >= MOVE_SUCCESS) distanceIncrease()
    }

    fun distanceIncrease() {
        distance++
    }

    companion object {
        private const val MAX_RANDOM = 10
        private const val MOVE_SUCCESS = 4
    }
}
