package racingcar

import kotlin.random.Random

class Car {
    var position = 1
        private set

    fun proceed() {
        val randomValue = Random.nextInt(10)

        if (canGo(randomValue)) {
            position++
        }
    }

    private fun canGo(randomValue: Int, threshold: Int = GO_THRESHOLD): Boolean {
        return randomValue >= threshold
    }

    companion object {
        private const val GO_THRESHOLD = 4
    }
}