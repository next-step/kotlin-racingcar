package racingcar.domain

class Car(private val moveDepth: Int = 1) {

    private var distance: Int = 0

    fun moveIfMoveable() {
        val random = java.util.Random()
        if (random.nextInt(10) >= 4) {
            move()
        }
    }

    private fun move() {
        distance += moveDepth
    }

    fun currentDistance(): Int {
        return distance
    }
}
