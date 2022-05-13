package camp.nextstep.edu.step3.racing

class Racing private constructor(participants: List<Car>, private val moveCount: Int) {

    private var ended = false
    private val carTracks = linkedMapOf(*participants.map { car -> car to Track(moveCount) }.toTypedArray())

    fun start() {
        for ((car, track) in carTracks) {
            car.raceOn(track, moveCount)
        }

        ended = true
    }

    fun result(): Map<Car, Track> {
        if (!ended) throw RuntimeException("racing is not ended")

        return carTracks
    }

    companion object {
        fun new(participants: List<Car>, moveCount: Int): Racing {
            return Racing(participants, moveCount)
        }
    }
}
