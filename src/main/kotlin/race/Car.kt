package race

import kotlin.random.Random

class Car {
    var position: Int = 0
        private set

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
        position = (position - 1).coerceAtLeast(0)
    }
}
