package racing

import kotlin.random.Random

data class Car(private var _position: Int = 1) {
    val position get() = _position

    fun moveOrStop() {
        val isMove = isMove { random(0..9) }
        if (isMove) {
            move()
        }
    }

    fun move() {
        _position += 1
    }

    companion object {
        fun random(range: IntRange) = Random.nextInt(range.first, range.last)

        fun isMove(intSupplier: () -> Int) = intSupplier() >= 4
    }
}
