package racingcar.service

class CarMoveForwardDecider(private val carMoveForwardValueGetter: CarMoveForwardValueGetter) {
    fun canMoveForward(): Boolean {
        return carMoveForwardValueGetter.get() >= CAR_MOVE_FORWARD_THRESHOLD
    }

    companion object {
        private const val CAR_MOVE_FORWARD_THRESHOLD = 4
    }
}
