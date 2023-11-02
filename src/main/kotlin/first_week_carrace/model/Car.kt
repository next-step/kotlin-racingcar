package first_week_carrace.model

import first_week_carrace.utils.MOVE_THRESHOLD
import first_week_carrace.utils.RANDOM_END_RANGE
import first_week_carrace.utils.RANDOM_START_RANGE

class Car(
    val name: String,
    private val decider: ForwardDecider = ForwardDecider {
        (RANDOM_START_RANGE..RANDOM_END_RANGE).random() >= MOVE_THRESHOLD
    }
) {

    var position = 1
        private set

    private fun isForward() = decider.execute()

    fun doForwardOrNot(): Int {
        if (isForward()) position++
        return position
    }
}
