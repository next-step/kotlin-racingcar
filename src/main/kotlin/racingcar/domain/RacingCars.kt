package racingcar.domain

import racingcar.common.RandomCommandGenerator

class RacingCars(
    private val cars: List<Car>
) {
    val size: Int = cars.size

    fun race(): List<CarRecord> {
        cars.forEach {
            val command = MovementCommand.of(RandomCommandGenerator.nextCommand())
            it.move(command)
        }

        return cars.map { it.getCarRecord() }
    }
}
