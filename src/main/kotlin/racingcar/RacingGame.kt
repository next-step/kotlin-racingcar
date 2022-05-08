package racingcar

class RacingGame(
    private val cars: List<Car>,
    private var laps: Int,
    private val movingStrategy: MovingStrategy = RandomStrategy()
) {
    private val roundReports: MutableList<List<Int>> = mutableListOf()

    fun start() {
        if (!isNotEnd()) throw IllegalStateException("이미 종료된 레이스입니다.")

        cars.forEach {
            it.move(movingStrategy)
            writeReport()
        }

        laps--
    }

    private fun writeReport() {
        roundReports.add(cars.map { it.position })
    }

    fun isNotEnd(): Boolean {
        return laps > END_GAME_LAPS
    }

    fun report(): List<List<Int>> {
        return roundReports
    }

    companion object {
        private const val END_GAME_LAPS = 0
    }
}
