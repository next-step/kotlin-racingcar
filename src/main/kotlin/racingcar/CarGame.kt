package racingcar

class CarGame(
    carCount: Int,
    totalPhase: Int,
    private val numberGenerator: NumberGenerator,
) {
    val cars: List<Car>
    var currentPhase: Int
        private set

    init {
        validateCount(carCount)
        validateCount(totalPhase)
        currentPhase = totalPhase
        cars = List(carCount) { Car() }
    }

    fun playSinglePhase() {
        check(isPlaying()) {
            "이미 종료된 게임입니다."
        }
        currentPhase -= SINGLE_PHASE
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    fun isPlaying(): Boolean {
        return currentPhase > 0
    }

    private fun validateCount(count: Int) {
        require(count > 0) { "횟수는 0보다 커야합니다." }
    }

    companion object {
        const val SINGLE_PHASE = 1
    }
}
