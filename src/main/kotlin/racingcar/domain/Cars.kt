package racingcar.domain

const val MINIMUM_WINNER_COUNT = 1

class Cars(carNames: List<String>, private val randomNumberGenerator: IRandomNumberGenerator) {
    private val cars = carNames.map { carName -> Car(carName) }

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
}
