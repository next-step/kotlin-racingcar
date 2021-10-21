package racingCar.model

class CarMove : Movement {

    override fun amount() = when (moveCondition()) {
        true -> FORWARD_AMOUNT
        false -> STOP_AMOUNT
    }

    private fun moveCondition() = (0..9).random() >= 4

    companion object {
        private const val FORWARD_AMOUNT = 1
        private const val STOP_AMOUNT = 0
    }
}
