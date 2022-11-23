package racingcar.application.race.event.listener

import racingcar.application.race.event.model.RaceEventData

sealed interface RaceListener<in T : RaceEventData> {
    fun publish(raceEventData: T)
}
