package racingcar.domain

class CarRace(carRaceProperties: CarRaceProperties) {
    private val participantCount = carRaceProperties.participantCount
    private val maxRound = carRaceProperties.maxRound
    private val raceMoveRule = carRaceProperties.raceMoveRule
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

data class CarRaceProperties(
    val participantCount: Long,
    val maxRound: Long,
    val raceMoveRule: RaceMoveRule = RandomRaceMoveRule(DefaultRandomGenerator())
)
