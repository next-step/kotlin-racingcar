package racingcar.domain

import racingcar.dto.RacingResultDTO

class Cars(carNames: CarNames) {

    private val cars: List<Car>

    init {
        cars = carNames.getCarNames().map { Car(it) }
    }

    fun racing() {
        cars.forEach {
            it.move(MOVEMENT_STRATEGY)
        }
    }

    fun racingResult(): List<RacingResultDTO> {
        return cars.map { RacingResultDTO(it.getCarName(), it.getDistance()) }.toList()
    }

    fun winners(): List<RacingResultDTO> {
        val winnerDistance = findWinnerDistance()
        return cars.filter { it.getDistance() == winnerDistance }
            .map { RacingResultDTO(it.getCarName(), it.getDistance()) }.toList()
    }

    private fun findWinnerDistance(): Int {
        val nullableWinnerCar = this.cars.maxWithOrNull(Comparator.comparingInt { it.getDistance() })
        requireNotNull(nullableWinnerCar) { "우승자를 출력할 수 없습니다." }
        return nullableWinnerCar.getDistance()
    }

    companion object {
        private val MOVEMENT_STRATEGY: MovementStrategy = RandomNumberMovementStrategy()
    }
}
