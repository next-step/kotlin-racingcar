package racingCar.model

class ForwardMovement {
    fun forward(mileage: Int) = mileage + MOVE_AMOUNT

    companion object {
        private const val MOVE_AMOUNT = 1
    }
}
