package carracing.domain

private const val MOVING_THRESHOLD = 4

data class Car(val name: String) {
    var movingCount: Int = 0
        private set

    fun move(movingFactor: Int) {
        if (movingFactor >= MOVING_THRESHOLD) {
            movingCount++
        }
    }
}
