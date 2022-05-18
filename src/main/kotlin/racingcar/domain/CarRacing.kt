package racingcar.domain

class CarRacing private constructor(carNames: String, private var moveCount: Int) {
    val cars = Cars.from(carNames)

    fun run(movingStrategy: MovingStrategy) {
        repeat(moveCount) {
            cars.run(movingStrategy)
        }
    }

    companion object {
        fun of(carNames: String, moveCount: Int): CarRacing {
            return CarRacing(carNames, moveCount)
        }
    }
}

