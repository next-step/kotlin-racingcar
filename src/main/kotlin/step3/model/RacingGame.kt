package step3.model

class RacingGame(
    private val numberGenerator: NumberGenerator,
    private val cars: List<Car>,
    private var currentTrialCount: Int = 0
) {
    companion object {
        private const val FORWARD_CONDITION = 4
    }

    fun run() {
        cars.forEach { car ->
            val randomNumber = numberGenerator.generate()
            if (randomNumber >= FORWARD_CONDITION) {
                car.move()
            }
        }
        increaseCount()
    }

    fun getCurrentTrialCount(): Int {
        return currentTrialCount
    }

    fun getResult(): List<Int> {
        return cars.map { car ->
            car.getPosition()
        }
    }

    private fun increaseCount() {
        currentTrialCount += 1
    }
}
