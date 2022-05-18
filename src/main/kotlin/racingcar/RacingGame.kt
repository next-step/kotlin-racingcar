package racingcar

class RacingGame(driverNames: List<String>, private val tryCount: Int) {
    val drivers = driverNames.map { Driver(it, Car()) }

    fun start() {
        repeat(tryCount) {
            drivers.forEach {
                val isMovable = MOVE_RANGE.random() >= MOVE_CONDITION
                it.drive(isMovable)
            }
        }
    }

    init {
        require(driverNames.size > MIN_CAR_COUNT) {
            throw RuntimeException(CAR_COUNT_ERROR_MESSAGE)
        }
    }

    companion object {
        private const val MIN_CAR_COUNT = 1
        private const val CAR_COUNT_ERROR_MESSAGE = "자동차는 최소 2대 이상 입력해주세요"
        private val MOVE_RANGE = (0..9)
        private const val MOVE_CONDITION = 4
    }
}
