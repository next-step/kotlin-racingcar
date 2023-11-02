package carracing.model.service

import carracing.model.model.Racing
import carracing.model.model.Snapshot

class RacingService {

    fun create(numberOfCar: Int): Racing {
        require(numberOfCar > 0) { "'numberOfCar' must be greater than 0" }
        return Racing(numberOfCar)
    }

    fun play(racing: Racing, numberOfAttempt: Int): List<Snapshot> {
        require(numberOfAttempt > 0) { "'numberOfAttempt' must be greater than 0" }
        val snapshots = mutableListOf<Snapshot>()
        for (i in 0 until numberOfAttempt) {
            racing.progress()
            snapshots.add(racing.takeSnapshot())
        }
        return snapshots
    }
}
