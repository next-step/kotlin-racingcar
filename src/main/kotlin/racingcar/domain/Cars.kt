package racingcar.domain

const val MINIMUM_WINNER_COUNT = 1

class Cars(private val cars: List<Car>, private val randomNumberGenerator: NumberGenerator) {
    fun move() {
        cars.forEach { car -> car.move(randomNumberGenerator.getGeneratedNumber()) }
    }

    fun getCarsNameWithPosition(): Map<String, Int> {
        return cars.associate { it.name to it.position }
    }

    fun getWinners(): List<String> {
        val winnerPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == winnerPosition }
        validateWinnersCount(winners)
        return winners.map { it.name }
    }

    private fun validateWinnersCount(winners: List<Car>) {
        require(winners.count() >= MINIMUM_WINNER_COUNT) { "우승자는 ${MINIMUM_WINNER_COUNT}명 이상이어야 합니다." }
    }

    companion object {
        fun of(carNames: List<String>, randomNumberGenerator: NumberGenerator): Cars =
            Cars(carNames.map { carName -> Car(carName) }, randomNumberGenerator)
    }
}
