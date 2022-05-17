package camp.nextstep.edu.racingcar.racing

class Racing(participants: List<Car>, private val moveCount: Int) {

    private var ended = false
    private var winners = setOf<Winner>()
    private val carRacingEvents = linkedMapOf(*participants.map { car -> car to mutableListOf<CarRaceEvent>() }.toTypedArray())

    init {
        require(participants.isNotEmpty())
        require(moveCount > 0) { "최소 1회 이상 움직일 수 있어야 합니다." }
    }

    fun start() {
        repeat(moveCount) {
            for ((car, events) in carRacingEvents) {
                events.add(car.race())
            }
        }

        ended = true
        winners = Winner.of(carRacingEvents)
    }

    fun carRacingEvents(): Map<Car, List<CarRaceEvent>> {
        check(ended) { "racing is not ended" }

        return carRacingEvents
    }

    fun winners(): Set<Winner> {
        check(ended) { "racing is not ended" }

        return winners
    }
}
