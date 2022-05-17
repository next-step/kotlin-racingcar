package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.CarRaceEvent

class CarTrackSnapshot(car: Car, events: List<CarRaceEvent>) {

    private val carName = car.name
    private val track = CarRaceEvent.merge(events)
    private val traces = track.traces().asSequence().joinToString(" ") { if (it) "⎼" else "" }

    override fun toString(): String {
        return "${carName}\t: $traces"
    }
}
