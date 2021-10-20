package step3.domain

import java.util.Random

class Car {
    private val random = Random()
    private var distance = 0

    fun forward() {
        if (random.nextInt(MAX_RANDOM) >= 4) distance++
    }

    companion object {
        private const val MAX_RANDOM = 10
        private const val MOVE_SUCCESS = 4
    }
}
