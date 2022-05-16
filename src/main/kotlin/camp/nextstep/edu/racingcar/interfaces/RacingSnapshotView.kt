package camp.nextstep.edu.racingcar.interfaces

import camp.nextstep.edu.racingcar.racing.Racing

class RacingSnapshotView(racing: Racing, movements: Int) {

    val racingResults = racing.result().map { CarTrackView(it.key, it.value, movements) }
}
