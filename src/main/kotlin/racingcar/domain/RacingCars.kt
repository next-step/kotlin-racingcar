package racingcar.domain

import racingcar.common.RandomCommandGenerator

class RacingCars(
    private val cars: List<Car>
) {
    val size: Int = cars.size

    fun race(): RaceRecord {
        cars.forEach {
            val command = MovementCommand.of(RandomCommandGenerator.nextCommand())
            it.move(command)
        }
        return RaceRecord(cars.map { it.captureState() })
    }
}

data class RaceRecord(
    val cars: List<Car.State>
)
