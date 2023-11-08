package carracing.domain

class Car {
    var movingCount: Int = 0
        private set

    fun move(movingFactor: Int) {
        if (movingFactor >= 4) {
            movingCount++
        }
    }
}
