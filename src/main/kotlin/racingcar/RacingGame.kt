package racingcar

object RacingGame {
    fun play(carNum: Int, records: GameRecords, randomNumStrategy: MoveStrategy): GameRecords {
        for (i in 0 until carNum) {
            records.cars[i].move(randomNumStrategy)
        }
        return records
    }
}
