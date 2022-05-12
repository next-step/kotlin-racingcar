package racingcar.model

import kotlin.random.Random

open class Car(position: Int = DEFAULT_POSITION) {
    constructor(car: Car) : this(car.position)

    var position: Int = position
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
