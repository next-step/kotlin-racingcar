package racingcar.controller

class RacingCarGame(
    numberOfCar: Int,
    private val numberOfTrial: Int,
    private val conditionProvider: ConditionProvider = RandomNumberProvider
) {
    private val cars: List<Car>

    init {
        require(numberOfCar > 0) { "자동차 대수는 1대 이상이여야 합니다" }
        require(numberOfTrial > 0) { "시도 횟수는 1회 이상이여야 합니다" }

        this.cars = List(numberOfCar) { Car() }
    }

    fun startGame(): RacingCarGameSnapShots {
        val snapShots = MutableList(numberOfTrial) { move() }
        return RacingCarGameSnapShots(snapShots)
    }

    private fun move(): RacingCarGameSnapShot {
        cars.forEach {
            val nextMovement = MovePolicy.decide(conditionProvider.nextCondition())
            it.move(nextMovement)
        }

        val positions = cars.map { it.currentPosition }.toList()
        return RacingCarGameSnapShot(positions)
    }
}
