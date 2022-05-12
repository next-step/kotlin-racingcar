package racingcar.domain

class RacingGame(
    private val cars: Cars,
    private var laps: Int,
    private val movingStrategy: MovingStrategy = DefaultStrategy(),
    val report: RacingGameReport = RacingGameReport()
) {

    fun start() {
        if (!isNotEnd()) throw IllegalStateException("이미 종료된 레이스입니다.")
        cars.move(movingStrategy)
        writeReport()
        laps--
    }

    private fun writeReport() {
        report.add(LapReport(cars.nameWithLocation()))
    }

    fun isNotEnd(): Boolean {
        return laps > END_GAME_LAPS
    }

    companion object {
        private const val END_GAME_LAPS = 0
    }
}
