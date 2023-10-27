package racing

import kotlin.random.Random

data class Car(private var position: Int = 1) {
    fun getResult(): String = (1..position).map { "-" }.reduce { a, b -> a + b }

    fun moveOrStop() {
        val isMove = isMove { random(0..9) }
        if (isMove) {
            move()
        }
    }

    fun move() {
        position += 1
    }

    companion object {
        fun random(range: IntRange) = Random.nextInt(range.first, range.last)

        fun isMove(intSupplier: () -> Int) = intSupplier() >= 4
    }
}
