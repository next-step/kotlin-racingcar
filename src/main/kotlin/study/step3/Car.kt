package study.step3

import kotlin.random.Random

class Car {
    var mileage: Int = 0
        private set

    fun canMove(rpm: Int): Boolean {
        return rpm >= MIN_RPM_TO_MOVE
    }

    fun move() {
        val rpm = Random.nextInt(MAX_RPM + 1)
        if (canMove(rpm)) {
            mileage++
        }
    }

    companion object {
        const val MAX_RPM = 9
        const val MIN_RPM_TO_MOVE = 4
    }
}
