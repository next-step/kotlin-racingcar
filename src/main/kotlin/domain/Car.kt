package domain

import kotlin.random.Random

class Car {
    var position = 0
        private set

    fun move(isMoving: Boolean): Int {
        if (isMoving) position += 1
        return position
    }

    fun isMoving(): Boolean = Random.nextInt(9) >= 4
}
