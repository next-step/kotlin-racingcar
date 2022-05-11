package racingcar.domain

class RacingCars(
    private val cars: List<Car>
) {
    val size: Int = cars.size

    init {
        require(cars.isNotEmpty()) { "경주를 진행하기 위해선 최소 ${MINIMUM_NUMBER_OF_CARS}대 이상의 자동차가 필요합니다" }
    }

    fun race(movementCommandGenerator: MovementCommandGenerator): RaceRecord {
        cars.forEach {
            val command = movementCommandGenerator.generateMovement()
            it.move(command)
        }
        return RaceRecord(cars.map { it.captureState() })
    }

    companion object {
        const val MINIMUM_NUMBER_OF_CARS = 1
    }
}

data class RaceRecord(
    val cars: List<Car.State>
)
