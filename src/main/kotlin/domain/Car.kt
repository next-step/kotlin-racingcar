package domain

import kotlin.random.Random

class Car(
    private val _carId: Int
) {

    val carId = _carId
    var position = 0
        private set

    fun move() {
        if (canMove()) position += 1
    }

    private fun canMove(): Boolean = Random.nextInt(9) >= 4
}
