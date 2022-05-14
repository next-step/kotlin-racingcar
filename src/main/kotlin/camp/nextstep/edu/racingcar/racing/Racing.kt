package camp.nextstep.edu.racingcar.racing

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
        check(ended) { "racing is not ended" }

        return carTracks
    }

    companion object {
        fun new(participants: List<Car>, moveCount: Int): Racing {
            return Racing(participants, moveCount)
        }
    }
}
