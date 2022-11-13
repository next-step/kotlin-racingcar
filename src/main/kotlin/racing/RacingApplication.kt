package racing

import racing.domain.GoOrStopCarActionImpl
import racing.domain.RacingCarImpl
import racing.domain.RacingCarsFactoryImpl
import racing.domain.RandomMoveStrategy
import racing.model.CarCount
import racing.model.RoundCount

class RacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val carCount = InputView.readCarCount()?.let { CarCount(it) }
                ?: throw IllegalArgumentException("유효한 값이 아닙니다.")
            val roundCount = InputView.readRoundCount()?.let { RoundCount(it) }
                ?: throw IllegalArgumentException("유효한 값이 아닙니다.")

            val racingRecordBoard = RacingRecordBoard()
            val racingGame = RacingGame(
                racingCarGarage = RacingCarGarage(
                    carCount = carCount,
                    racingCarsFactory = RacingCarsFactoryImpl()
                ),
                racingCar = RacingCarImpl(
                    goOrStopCarAction = GoOrStopCarActionImpl(
                        moveStrategy = RandomMoveStrategy()
                    )
                )
            )
            repeat(roundCount.value) {
                val raceResult = racingGame.race()
                racingRecordBoard.add(raceResult)
            }
            ResultView.printRaceResult(racingRecordBoard.results)
        }
    }
}
