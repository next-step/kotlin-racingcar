package carracing.domain

private const val UPPER_NAME_LENGTH = 5
private const val MOVING_THRESHOLD = 4

data class Car(val name: String) {

    init {
        require(name.length <= UPPER_NAME_LENGTH) { "'name' cannot exceed $UPPER_NAME_LENGTH characters" }
    }

    var movingCount: Int = 0
        private set

    fun move(movingFactor: Int) {
        if (movingFactor >= MOVING_THRESHOLD) {
            movingCount++
        }
    }
}
