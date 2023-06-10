package race

import kotlin.random.Random

class Car {
    private var position = 0

    fun getPosition(): Int = position

    fun move() {
        if (canGoStraight()) {
            straight()
        } else {
            back()
        }
    }

    private fun canGoStraight(): Boolean {
        return 4 <= Random.nextInt(10)
    }

    private fun straight() {
        position++
    }

    private fun back() {
        position = maxOf(0, position - 1)
    }
}
