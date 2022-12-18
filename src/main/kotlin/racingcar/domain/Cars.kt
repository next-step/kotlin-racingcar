package racingcar.domain

class Cars(private val cars: List<Car>) {
    init {
        require(cars.isNotEmpty()) { "자동차 대수는 1대 이상이여야 합니다" }
    }

    fun move(conditionProvider: ConditionProvider): RacingCarGameSnapShot {
        cars.forEach {
            it.move(conditionProvider.nextCondition())
        }

        return RacingCarGameSnapShot(
            cars.map { CarSnapShot(it.name, it.currentPosition) }.toList()
        )
    }

    fun getWinnersOfGame(): List<String> {
        val winnerPosition = cars.maxOf { it.currentPosition }
        return cars.filter { it.currentPosition == winnerPosition }.map { it.name }
    }
}
