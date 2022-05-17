package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Racing

class RacingSnapshot(racing: Racing, movements: Int) {

    val carTracks: List<CarTrackSnapshot> = racing.carRacingEvents().map {
        (car, events) ->
        CarTrackSnapshot(car, events.take(movements))
    }
}
