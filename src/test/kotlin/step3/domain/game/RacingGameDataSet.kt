package step3.domain.game

import step3.domain.car.name.CarNameDataSet

class RacingGameDataSet {
    companion object {
        fun testData(
            carNameList: List<String> = CarNameDataSet.testDataList(RacingGame.DEFAULT_TOTAL_CAR_COUNT),
            totalTryCount: Int = RacingGame.DEFAULT_TOTAL_TRY_COUNT
        ) = RacingGame(carNameList = carNameList, totalTryCount = totalTryCount)
    }
}
