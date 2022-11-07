package racing

import racing.domain.GoOrStopCarActionImpl
import racing.domain.RacingCarsFactoryImpl
import racing.domain.RandomMovingCarConditionNumberImpl
import racing.model.CarCount
import racing.model.RoundCount

class RacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val count = InputView.readCarCount()
            val count2 = InputView.readRoundCount()

            val racingGame = RacingGame(
                carCount = CarCount(count),
                roundCount = RoundCount(count2),
                racingCarGarage = RacingCarGarage(
                    racingCarsFactory = RacingCarsFactoryImpl()
                ),
                goOrStopCarAction = GoOrStopCarActionImpl(
                    randomMovingCarConditionNumber = RandomMovingCarConditionNumberImpl()
                ),
            )
            racingGame.race()
        }
    }
}
