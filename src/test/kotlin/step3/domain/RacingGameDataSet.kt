package step3.domain

import java.util.UUID

class RacingGameDataSet {
    companion object {
        fun testData(): RacingGame = RacingGame()

        fun testData(
            totalCarCount: Int = RacingGame.DEFAULT_TOTAL_CAR_COUNT,
            totalTryCount: Int = RacingGame.DEFAULT_TOTAL_TRY_COUNT
        ) = RacingGame(totalCarCount = totalCarCount, totalTryCount = totalTryCount)

        fun testData(isReady: Boolean): RacingGame {
            val racingGame = testData()
            if (isReady) {
                repeat(racingGame.totalCarCount) {
                    racingGame.addRacingCar(UUID.randomUUID().toString().substring(0..4))
                }
            }
            return racingGame
        }
    }
}
