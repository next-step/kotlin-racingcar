package racingcar.domain

import racingcar.dto.RacingResultDTO

class Cars(carNames: CarNames) {

    private val cars: List<Car>

    init {
        cars = carNames.toList().map { Car(it) }
    }

    fun racing() {
        cars.forEach {
            it.move(MOVEMENT_STRATEGY)
        }
    }

    fun racingResult(): List<RacingResultDTO> {
        return cars.map { RacingResultDTO(it.getCarName(), it.getDistance()) }.toList()
    }

    companion object {
        private val MOVEMENT_STRATEGY: MovementStrategy = RandomNumberMovementStrategy()
    }
}
