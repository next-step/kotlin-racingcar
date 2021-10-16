package model

import java.util.Random

data class Car(
    var movement: Int = 0
) {
    fun move() {
        when (Random().nextInt(9)) {
            in 0..3 -> stop()
            else -> forward()
        }
    }

    private fun forward() {
        movement += 1
    }

    private fun stop() {
        movement
    }
}
