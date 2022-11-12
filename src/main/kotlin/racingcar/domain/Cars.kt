package racingcar.domain

import racingcar.dto.RacingResultDTO
import racingcar.model.NonNegative

class Cars(numberOfCars: NonNegative) {

    private val cars: List<Car>

    init {
        cars = List(numberOfCars.getNonNegativeValue()) { Car() }
    }

    fun racing() {
        cars.forEach {
            it.move(MOVEMENT_STRATEGY)
        }
    }

    fun racingResult(): List<RacingResultDTO> {
        return cars.map { RacingResultDTO(it.getDistance()) }.toList()
    }

    companion object {
        private val MOVEMENT_STRATEGY: MovementStrategy = RandomNumberMovementStrategy()
    }
}
