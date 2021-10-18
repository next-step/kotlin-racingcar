package racingcar

class CarMoveForwardDecider(private val carMoveForwardValueGetter: CarMoveForwardValueGetter) {
    companion object {
        private const val CAR_MOVE_FORWARD_THRESHOLD = 4
    }

    fun canMoveForward(): Boolean {
        return carMoveForwardValueGetter.get() >= CAR_MOVE_FORWARD_THRESHOLD
    }
}
