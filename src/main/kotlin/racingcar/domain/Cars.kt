package racingcar.domain

class Cars(carNames: CarNames) {

    companion object {
        private val MOVEMENT_STRATEGY: MovementStrategy = RandomNumberMovementStrategy()
    }

    private val cars: List<Car>

    init {
        cars = carNames.toList().map { Car(carName = it) }.toList()
    }

    fun racing() {
        cars.forEach {
            it.move(MOVEMENT_STRATEGY)
        }
    }

    fun racingResult(): List<RacingResultDTO> {
        return cars.map { RacingResultDTO(it.carName.text, it.distance.toInt()) }.toList()
    }

    fun winners(): List<RacingResultDTO> {
        val winnerDistance = findWinnerDistance()
        return cars.filter { it.distance.toInt() == winnerDistance }
            .map { RacingResultDTO(it.carName.text, it.distance.toInt()) }.toList()
    }

    private fun findWinnerDistance(): Int {
        return this.cars.maxWithOrNull(Comparator.comparingInt { it.distance.toInt() })!!.distance.toInt()
    }
}
