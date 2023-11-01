package carracing.model.service

import carracing.model.model.Racing
import carracing.model.model.Snapshot

class RacingService {

    fun create(numberOfCar: Int): Racing {
        return Racing(numberOfCar)
    }

    fun play(racing: Racing, numberOfAttempt: Int): List<Snapshot> {
        val snapshots = mutableListOf<Snapshot>()
        for (i in 0 until numberOfAttempt) {
            racing.progress()
            snapshots.add(racing.takeSnapshot())
        }
        return snapshots
    }
}
