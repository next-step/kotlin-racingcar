package racingcar.domain

class Round(private val cars: List<Car>) {

    private lateinit var gameResult: Result

    fun play() {
        cars.forEach { it.moveIfMoveable() }
        gameResult = Result(cars.map { it.currentDistance() })
    }

    fun result(): Result {
        return gameResult
    }
}
