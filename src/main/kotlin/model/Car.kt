package model

import kotlin.random.Random

class Car {
    private var distance: Int = 1

    fun goStop() {
        if (canProceed())
            distance++
    }

    fun getDistance() = distance

    private fun canProceed() = Random.nextInt(0, 10) >= 4
}
