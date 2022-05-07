package racingcar

import kotlin.random.Random

class Car {
    var position = 1

    fun proceed() {
        if (canGo()) {
            position++
        }
    }

    private fun canGo(): Boolean {
        val randomNumber = Random.nextInt(10)

        return randomNumber >= 4
    }
}