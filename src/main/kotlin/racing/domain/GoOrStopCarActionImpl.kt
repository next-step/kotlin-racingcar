package racing.domain

import racing.model.CarAction

class GoOrStopCarActionImpl(
    private val moveStrategy: MoveStrategy
) : GoOrStopCarAction {
    override fun castCarAction(): CarAction =
        if (moveStrategy.move()) CarAction.GO else CarAction.STOP
}
