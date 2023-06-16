package racingame.domain

class RacingGame(
    private val cars: Cars,
    private val totalTrialCount: Int
) {
    var positionHistories: List<Cars> = listOf()
        private set

    fun run(): Winner {
        repeat(totalTrialCount) {
            race()
        }
        return Winner(cars)
    }

    private fun race() {
        val currentHistories = Cars()
        cars.values.forEach { car ->
            car.move()
            currentHistories.add(car)
        }
        positionHistories = positionHistories + currentHistories
    }
}
