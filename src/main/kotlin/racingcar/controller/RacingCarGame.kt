package racingcar.controller

class RacingCarGame(
    carNames: List<String>,
    private val numberOfTrial: Int,
    private val conditionProvider: ConditionProvider = RandomNumberProvider
) {

    private val cars: List<Car>

    init {
        require(carNames.isNotEmpty()) { "자동차 대수는 1대 이상이여야 합니다" }
        require(numberOfTrial > 0) { "시도 횟수는 1회 이상이여야 합니다" }

        this.cars = carNames.map { Car(it) }
    }

    fun startGame(): RacingCarGameSnapShots {
        val snapShots = List(numberOfTrial) { move() }
        return RacingCarGameSnapShots(snapShots)
    }

    private fun move(): RacingCarGameSnapShot {
        cars.forEach {
            it.move(conditionProvider.nextCondition())
        }

        return RacingCarGameSnapShot(
            cars.map { CarSnapShot(it.name, it.currentPosition) }.toList()
        )
    }
}
