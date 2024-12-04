package week1.racing.domain

class RacingCar(
    val name: String,
    private val carMovementDecider: MovementDecider,
    startingPosition: Int = 1,
) {
    init {
        require(name.length <= MAX_CAR_NAME_LENGTH) {
            "Car name is too long ! (max length = $MAX_CAR_NAME_LENGTH, current = ${name.length})"
        }
    }

    var currentPosition = startingPosition
        private set

    fun moveForward() {
        if (carMovementDecider.shouldMove()) {
            ++currentPosition
        }
    }

    companion object {
        private const val MAX_CAR_NAME_LENGTH = 5
    }
}
