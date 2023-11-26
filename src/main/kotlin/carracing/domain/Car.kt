package carracing.domain

import kotlin.random.Random

data class Car(
    val name: String,
) {
    var position: Int = 0
        private set

    fun move() {
        if (isMove()) {
            position++
        }
    }

    fun copy() = Car(name).apply {
        this.position = this@Car.position
    }

    private fun isMove(): Boolean {
        val num = Random.nextInt(RANDOM_RANGE)
        return num >= MOVE_VALUE
    }

    companion object {
        private const val RANDOM_RANGE = 10
        private const val MOVE_VALUE = 4
    }
}