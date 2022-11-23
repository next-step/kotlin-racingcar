package racingcar.application.race.event.model

import racingcar.application.race.event.listener.RoundListener
import racingcar.application.race.event.listener.WinListener

sealed interface RaceEvent<in T : RaceEventData> {
    fun publish(raceEventData: T)
}

class RoundEvent(
    private val listeners: List<RoundListener>
) : RaceEvent<RoundEventCarData> {
    override fun publish(raceEventData: RoundEventCarData) {
        listeners.forEach { it.publish(raceEventData = raceEventData) }
    }
}

class WinEvent(
    private val listeners: List<WinListener>
) : RaceEvent<WinEventCarData> {
    override fun publish(raceEventData: WinEventCarData) {
        listeners.forEach { it.publish(raceEventData = raceEventData) }
    }
}
