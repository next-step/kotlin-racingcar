package racing.domain

import racing.model.CarAction

class FakeGoOrStopCarAction(
    private val fakeCarAction: CarAction
) : GoOrStopCarAction {
    override fun castCarAction(): CarAction = fakeCarAction
}
