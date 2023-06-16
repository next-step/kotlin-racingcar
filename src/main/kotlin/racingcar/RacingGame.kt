package racingcar

class RacingGame(private val cars: Cars, private val tryCount: Int) {
    private val gameResult: MutableList<PositionHistory> = mutableListOf()

    fun run(): RacingGameResult {
        repeat(tryCount) {
            gameResult.add(PositionHistory(cars.moveAll()))
        }

        return RacingGameResult(gameResult)
    }
}
