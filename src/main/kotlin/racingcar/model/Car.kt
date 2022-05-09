package racingcar.model

import kotlin.random.Random

open class Car {
    var position: Int = 0
        private set

    fun move() {
        if (getRandomNumber() >= FORWARD_NUMBER) position++
    }

    protected open fun getRandomNumber(): Int {
        return Random.nextInt(MAX_BOUND)
    }

    companion object {
        const val DEFAULT_POSITION: Int = 0
        const val FORWARD_NUMBER: Int = 4
        const val MAX_BOUND: Int = 9
    }
}
