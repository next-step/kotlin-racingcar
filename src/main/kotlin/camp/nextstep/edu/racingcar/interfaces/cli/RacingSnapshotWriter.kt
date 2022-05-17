package camp.nextstep.edu.racingcar.interfaces.cli

import camp.nextstep.edu.racingcar.interfaces.RacingSnapshot

object RacingSnapshotWriter {

    fun writeRacingSnapshot(snapshot: RacingSnapshot) {
        println(snapshot.carTracks.joinToString("\n"))
    }
}
