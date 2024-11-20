package racingcar

class CarGame(
    carNames: List<String>,
    totalPhase: Int,
    private val numberGenerator: NumberGenerator,
) {
    private val raceAggregateSystem: RaceAggregateSystem
    val cars: List<Car>
    var currentPhase: Int
        private set

    init {
        validateCount(carNames.size)
        validateCount(totalPhase)
        currentPhase = totalPhase
        cars = carNames.map { Car(it) }
        raceAggregateSystem = RaceAggregateSystem(cars)
    }

    fun startRace(): RaceAggregateSystem {
        while (isPlaying()) {
            playSinglePhase()
            raceAggregateSystem.recordPhaseResult(currentPhase, cars)
        }
        return raceAggregateSystem
    }

    fun playSinglePhase() {
        check(isPlaying()) {
            "이미 종료된 게임입니다."
        }
        currentPhase -= SINGLE_PHASE
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    private fun isPlaying(): Boolean {
        return currentPhase > 0
    }

    private fun validateCount(count: Int) {
        require(count > 0) { "입력된 횟수: ${count}는 0보다 커야 합니다." }
    }

    companion object {
        const val SINGLE_PHASE = 1
    }
}
