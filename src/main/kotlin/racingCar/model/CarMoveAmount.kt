package racingCar.model

class CarMoveAmount(private val move: Int) : MoveAmount {

    override fun amount() = when (CarMoveCondition(move).isValid()) {
        true -> FORWARD_AMOUNT
        false -> STOP_AMOUNT
    }

    companion object {
        private const val FORWARD_AMOUNT = 1
        private const val STOP_AMOUNT = 0
    }
}
