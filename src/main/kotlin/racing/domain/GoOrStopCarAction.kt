package racing.domain

import racing.model.CarAction

interface GoOrStopCarAction {
    fun castCarAction(): CarAction
}
