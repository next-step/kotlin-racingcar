package racingcar

class RacingCarGame(
    numberOfCar: Int,
    private val numberOfTrial: Int,
    private val movePolicy: MovePolicy = RandomMovePolicy()
) {
    private val cars: List<Car>

    init {
        require(numberOfCar > 0) { "자동차 대수는 1대 이상이여야 합니다" }
        require(numberOfTrial > 0) { "시도 횟수는 1회 이상이여야 합니다" }

        this.cars = List(numberOfCar) { i -> Car(i) }
    }

    fun startGame(): RacingCarGameSnapShots {
        repeat(numberOfTrial) {
            move(it)
        }
        return RacingCarGameSnapShots(cars)
    }

    private fun move(atTrial: Int) {
        cars.forEach {
            val nextMovement = movePolicy.decide(it, atTrial)
            it.move(nextMovement)
        }
    }

    interface MovePolicy {
        fun decide(car: Car, atTrial: Int): Int
    }

    class RandomMovePolicy : MovePolicy {

        override fun decide(car: Car, atTrial: Int): Int {
            val random: Int = ((Math.random() * 10)).toInt()
            return if (random < 4) 0 else random
        }
    }
}
