package model

import kotlin.random.Random

open class Car(val name: String) {
    private var position = 0

    fun move() {
        if (generateRandomNumber() >= 4) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }

    open fun generateRandomNumber(): Int {
        return Random.nextInt(0, 10)
    }
}