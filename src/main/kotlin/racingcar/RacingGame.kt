package racingcar

object RacingGame {
    fun play(records: GameRecords, randomNumStrategy: MoveStrategy): GameRecords {
        records.cars.forEach{it.move(randomNumStrategy)}
        return records
    }
}
