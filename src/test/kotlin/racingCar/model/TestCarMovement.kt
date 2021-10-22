package racingCar.model

class TestCarMovement(private val distance: () -> Int) : Movement {
    override fun amount(): Int = when (distance.invoke() >= 4) {
        true -> FORWARD_AMOUNT
        false -> STOP_AMOUNT
    }

    companion object {
        private const val FORWARD_AMOUNT = 1
        private const val STOP_AMOUNT = 0
    }
}
