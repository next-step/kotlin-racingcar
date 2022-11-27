package racing

import racing.domain.GoOrStopCarActionImpl
import racing.domain.RacingCarsFactoryImpl
import racing.domain.RacingImpl
import racing.domain.RandomMoveStrategy
import racing.model.CarName
import racing.model.RoundCount

class RacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val (carNames, roundCount) = InputView.getRaceInfo()
                .let { (carNames, roundCount) ->
                    carNames.map { driver -> CarName(driver) } to (roundCount?.let { RoundCount(it) })
                }
            require(carNames.isNotEmpty()) { "유효한 자동차 이름이 아닙니다." }
            requireNotNull(roundCount) { "유효한 시도횟수 입력 값이 아닙니다." }

            val racingGame = RacingGame(
                racingCarGarage = RacingCarGarage(
                    carNames = carNames,
                    racingCarsFactory = RacingCarsFactoryImpl()
                ),
                racing = RacingImpl(
                    goOrStopCarAction = GoOrStopCarActionImpl(
                        moveStrategy = RandomMoveStrategy()
                    )
                ),
                racingRecordBoard = RacingRecordBoard()
            )
            racingGame.start(roundCount)
            val (result, winners) = racingGame.getRacingResultAndWinners()
            ResultView.printRaceResult(result, winners)
        }
    }
}
