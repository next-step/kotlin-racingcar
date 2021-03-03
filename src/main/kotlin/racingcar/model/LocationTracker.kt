package racingcar.model

import racingcar.util.Message
import racingcar.util.Message.Companion.DEFAULT_DISTANCE

data class LocationTracker(private var distance: Int = DEFAULT_DISTANCE) {

    fun getCurrentState() = Message.ONE_DISTANCE.repeat(distance)

    fun update(distance: Int) {
        this.distance += distance
    }
}
