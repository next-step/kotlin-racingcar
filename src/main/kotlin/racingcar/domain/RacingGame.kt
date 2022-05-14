package racingcar.domain

class RacingGame(
    private val cars: Cars,
    private var laps: Int,
    private val movingStrategy: MovingStrategy = DefaultStrategy(),
    val record: RacingGameRecord = RacingGameRecord()
) {

    fun start() {
        if (!isNotEnd()) throw IllegalStateException("이미 종료된 레이스입니다.")
        cars.move(movingStrategy)
        writeRecord()
        laps--
    }

    private fun writeRecord() {
        record.add(LapRecord(cars.carRecord()))
    }

    fun isNotEnd(): Boolean {
        return laps > END_GAME_LAPS
    }

    companion object {
        private const val END_GAME_LAPS = 0
    }
}
