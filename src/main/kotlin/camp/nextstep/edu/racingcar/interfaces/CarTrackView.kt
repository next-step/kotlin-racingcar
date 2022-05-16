package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.Track

class CarTrackView(car: Car, track: Track) {
    private val carName = car.name
    private val traces = track.traces().asSequence().toList()

    fun traces(to: Int): String {
        return "${carName}\t: ${traces.take(to).joinToString(" ") { if (it) "⎼" else "" }}"
    }
}
