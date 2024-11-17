package racingcar

class CarGame(
    carCount: Int,
    repeatCount: Int,
) {
    private var currentPhase: Int
    private val cars: List<Car>
    private val numberGenerator: RandomNumberGenerator

    init {
        validateCount(carCount)
        validateCount(repeatCount)
        currentPhase = repeatCount
        cars = MutableList(carCount) { Car() }
        numberGenerator = RandomNumberGenerator(RANDOM_FROM, RANDOM_UNTIL)
    }

    fun playGame() {
        currentPhase -= SINGLE_PHASE
        for (car in cars) {
            car.move(numberGenerator.generate())
        }
    }

    fun getResult(): String {
        val sb = StringBuilder()
        cars.forEach { sb.appendLine(it.moveCountStr) }
        return sb.toString()
    }

    fun isRunning(): Boolean {
        return currentPhase > 0
    }

    private fun validateCount(count: Int) {
        require(count > 0) { "횟수는 0보다 커야합니다." }
    }

    companion object {
        const val RANDOM_FROM = 0
        const val RANDOM_UNTIL = 10
        const val SINGLE_PHASE = 1
    }
}
