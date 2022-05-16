package camp.nextstep.edu.racingcar.interfaces.cli

import camp.nextstep.edu.racingcar.interfaces.RacingSnapshotView

object RacingSnapshotWriter {

    fun writeRacingSnapshot(snapshot: RacingSnapshotView) {
        println(snapshot.racingResults.joinToString("\n"))
    }
}
