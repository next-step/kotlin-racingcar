package racing.domain

import racing.model.CarAction

class GoOrStopCarActionImpl(
    private val randomMovingCarConditionNumber: RandomMovingCarConditionNumber
) : GoOrStopCarAction {
    override fun castCarAction(): CarAction =
        if (randomMovingCarConditionNumber.random() >= MOVING_CAR_CONDITION) {
            CarAction.GO
        } else {
            CarAction.STOP
        }

    companion object {
        private const val MOVING_CAR_CONDITION = 4
    }
}
