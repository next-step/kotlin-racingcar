package camp.nextstep.edu.racingcar.racing

class Racing private constructor(participants: List<Car>, private val moveCount: Int) {

    private var ended = false
    private var winners = setOf<Car>()
    private val carEvents = linkedMapOf(*participants.map { car -> car to mutableListOf<CarRaceEvent>() }.toTypedArray())

    fun start() {
        repeat(moveCount) {
            for ((car, events) in carEvents) {
                events.add(car.race())
            }
        }

        val racingResults = carEvents.map { it.key to CarRaceEvent.merge(it.value).marks() }
        val winnersCount = racingResults.maxOf { it.second }
        winners = racingResults.filter { it.second == winnersCount }.map { it.first }.toSet()

        ended = true
    }

    fun carRacingEvents(): Map<Car, List<CarRaceEvent>> {
        check(ended) { "racing is not ended" }

        return carEvents
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
