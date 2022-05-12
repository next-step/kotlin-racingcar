package model

import kotlin.random.Random

class Car {
    private val threshold: Int = 4

    private var distance: Int = 1

    fun go() {
        distance++
    }

    fun tryToGo() {
        if (canGo())
            go()
    }

    fun getDistance() = distance

    private fun canGo() = Random.nextInt(0, 10) >= threshold
}
