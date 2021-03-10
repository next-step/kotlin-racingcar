package racingcar.model

import racingcar.util.Message
import racingcar.util.Message.Companion.DEFAULT_DISTANCE

data class LocationTracker(var distance: Int = DEFAULT_DISTANCE) {
    var currentPosition: Int = distance
        private set

    fun getCurrentState() = Message.ONE_DISTANCE.repeat(currentPosition)

    fun update(distance: Int) {
        currentPosition += distance
    }
}
