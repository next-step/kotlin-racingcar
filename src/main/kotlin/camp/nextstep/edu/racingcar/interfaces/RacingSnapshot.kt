package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.CarRaceEvent

class RacingSnapshot(carRacingEvents: Map<Car, List<CarRaceEvent>>) {

    val carTracks: List<CarTrackSnapshot> = carRacingEvents.map {
        (car, events) ->
        CarTrackSnapshot(car, events)
    }
}
