package racingcar.domain

class CarRace(
    participantCount: Long,
    private var maxRound: Long,
    private val raceMoveRule: RaceMoveRule = RandomRaceMoveRule(DefaultRandomGenerator())
) {
    private val cars: List<Car> = MutableList(participantCount.toInt()) { CarFactory.newCar() }
    private var currentRound = 0L

    fun finished(): Boolean = currentRound >= maxRound

    fun raceStatus(): RaceStatus = RaceStatus.of(finished(), cars)

    fun doRace(): RaceStatus {
        if (finished()) return raceStatus()
        increaseRound()

        cars.filter { raceMoveRule.canMove(it) }.forEach {
            it.moveForward()
        }

        return raceStatus()
    }

    private fun increaseRound() {
        currentRound++
    }
}
