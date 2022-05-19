package racingcar

class RacingGame(val drivers: List<Driver>, val tryCount: Int) {
    private val carCount = drivers.size

    fun start() {
        repeat(tryCount) {
            drivers.forEach {
                val isMovable = MOVE_RANGE.random() >= MOVE_CONDITION
                it.drive(isMovable)
            }
        }
    }

    fun getWinner(): List<String> {
        val maxMovement = drivers.maxOf { it.driveRecord.last() }

        return drivers.filter { it.driveRecord.last() == maxMovement }.map { it.name }
    }

    init {
        require(carCount > MIN_CAR_COUNT) {
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
