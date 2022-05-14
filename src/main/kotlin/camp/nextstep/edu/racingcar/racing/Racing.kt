package camp.nextstep.edu.racingcar.racing

class Racing private constructor(participants: List<Car>, private val moveCount: Int) {

    private var ended = false
    private var winners = setOf<Car>()
    private val carTracks = linkedMapOf(*participants.map { car -> car to Track(moveCount) }.toTypedArray())

    fun start() {
        val racingResults = mutableListOf<Pair<Car, Int>>()

        for ((car, track) in carTracks) {
            car.raceOn(track, moveCount)
            racingResults.add(car to track.marks())
        }

        val winnersCount = racingResults.maxOf { it.second }
        winners = racingResults.filter { it.second == winnersCount }.map { it.first }.toSet()

        ended = true
    }

    fun result(): Map<Car, Track> {
        check(ended) { "racing is not ended" }

        return carTracks
    }

    fun winners(): Set<Car> {
        check(ended) { "racing is not ended" }

        return winners
    }

    companion object {
        fun new(participants: List<Car>, moveCount: Int): Racing {
            return Racing(participants, moveCount)
        }
    }
}
