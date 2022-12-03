package racingcar.domain

import racingcar.domain.Car.ActionType.GO
import racingcar.domain.Car.ActionType.STOP

class Car(
    val name: Name,
    distance: Int = 0
) {
    var distance: Int = distance
        private set

    private fun go() = distance++

    fun action(action: ActionType = getActionType()) {
        when (action) {
            STOP -> Unit
            GO -> go()
        }
    }

    private fun getActionType(): ActionType {
        return if (RandomNumGenerator.generate(MIN, MAX) >= STANDARD_NUMBER) GO
        else STOP
    }

    enum class ActionType {
        STOP,
        GO;
    }

    companion object {
        private const val MIN = 0
        private const val MAX = 9
        private const val STANDARD_NUMBER = 4
    }
}
