package racingcar

object RacingGame {
    fun run(cars: Cars, tryCount: Int): RacingGameResult {
        val gameResult = List(tryCount) { PositionHistory(cars.moveAll()) }

        return RacingGameResult(gameResult)
    }
}
