package racing

import racing.domain.GoOrStopCarActionImpl
import racing.domain.RacingCarsFactoryImpl
import racing.domain.RacingImpl
import racing.domain.RandomMoveStrategy

class RacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val racingGame = RacingGame(
                inputView = InputView,
                resultView = ResultView,
                racingCarGarage = RacingCarGarage(
                    racingCarsFactory = RacingCarsFactoryImpl()
                ),
                racing = RacingImpl(
                    goOrStopCarAction = GoOrStopCarActionImpl(
                        moveStrategy = RandomMoveStrategy()
                    )
                ),
                racingRecordBoard = RacingRecordBoard()
            )
            val (drivers, roundCount) = racingGame.getRaceInfo()
            racingGame.start(drivers, roundCount)
            val (result, winners) = racingGame.getRacingResultAndWinners()
            racingGame.printResult(result, winners)
        }
    }
}
