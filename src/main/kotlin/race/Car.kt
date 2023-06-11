package race

import kotlin.random.Random

class Car {

    var position: Int = 0
        private set

    fun copyRecord(): CarRecord {
        return CarRecord(position)
    }

    fun move() {
        if (canGoStraight()) {
            straight()
        }
    }

    private fun canGoStraight(): Boolean {
        return 4 <= Random.nextInt(10)
    }

    private fun straight() {
        position++
    }
}
