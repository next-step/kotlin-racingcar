package racing.domain

import racing.model.CarAction

class GoOrStopCarActionImpl(
    private val randomMovingCarConditionNumber: RandomMovingCarConditionNumber
) : GoOrStopCarAction {
    override fun castCarAction(): CarAction {
        TODO("Not yet implemented")
    }
}
