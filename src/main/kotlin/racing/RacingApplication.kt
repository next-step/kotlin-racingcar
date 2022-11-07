package racing

import racing.domain.GoOrStopCarActionImpl
import racing.domain.RacingCarsFactoryImpl
import racing.domain.RandomMovingCarConditionNumberImpl
import racing.model.CarCount
import racing.model.ResultView
import racing.model.RoundCount

class RacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val carCount = InputView.readCarCount()
            val roundCount = InputView.readRoundCount()

            val racingGame = RacingGame(
                carCount = CarCount(carCount),
                roundCount = RoundCount(roundCount),
                racingCarGarage = RacingCarGarage(
                    racingCarsFactory = RacingCarsFactoryImpl()
                ),
                goOrStopCarAction = GoOrStopCarActionImpl(
                    randomMovingCarConditionNumber = RandomMovingCarConditionNumberImpl()
                ),
            )
            racingGame.race()
            ResultView.printRaceResult(racingGame.results)
        }
    }
}
