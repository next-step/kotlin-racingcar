package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.CarRaceEvent
import camp.nextstep.edu.racingcar.racing.CarRaceEvent.Companion.merge

class CarTrackSnapshot(car: Car, events: List<CarRaceEvent>) {

    private val carName = car.name
    private val track = events.merge()
    private val traces = track.traces().joinToString(" ") { if (it) "⎼" else "" }

    override fun toString(): String {
        return "${carName}\t: $traces"
    }
}
