package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.Track

class CarTrackView(car: Car, track: Track) {
    private val carName = car.name
    private val traces = track.traces().asSequence().joinToString(" ") { if (it) "⎼" else "" }

    override fun toString(): String {
        return "${carName}\t: $traces"
    }
}
