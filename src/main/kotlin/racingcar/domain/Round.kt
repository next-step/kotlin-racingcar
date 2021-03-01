package racingcar.domain

class Round(private val cars: List<Car>) {

    private lateinit var gameResult: Result

    fun play() {
        check(!this::gameResult.isInitialized) { "이미 진행된 라운드입니다" }

        cars.forEach { it.moveIfMoveable() }
        gameResult = Result(cars.map { it.currentDistance() })
    }

    fun result(): Result {
        return gameResult
    }
}
