package step3.domain.game

class RacingGameDataSet {
    companion object {
        fun testData(): RacingGame = RacingGame()

        fun testData(
            totalCarCount: Int = RacingGame.DEFAULT_TOTAL_CAR_COUNT,
            totalTryCount: Int = RacingGame.DEFAULT_TOTAL_TRY_COUNT
        ) = RacingGame(totalCarCount = totalCarCount, totalTryCount = totalTryCount)
    }
}
