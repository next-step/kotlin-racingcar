package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.CarRaceEvent
import camp.nextstep.edu.racingcar.racing.Racing

class RacingSnapshotView(racing: Racing, movements: Int) {

    val racingResults = racing.carRacingEvents().map {
        CarTrackView(it.key, CarRaceEvent.merge(it.value.take(movements)))
    }
}
