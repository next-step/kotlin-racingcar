package racing

import racing.domain.GoOrStopCarActionImpl
import racing.domain.RacingCarImpl
import racing.domain.RacingCarsFactoryImpl
import racing.domain.RandomMoveStrategy
import racing.model.Driver
import racing.model.RoundCount

class RacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val drivers = InputView.readCarDrivers()
                .let { it.map { driver -> Driver(driver) } }
            require(drivers.isNotEmpty()) { "유효한 입력 값이 아닙니다." }
            val roundCount = InputView.readRoundCount()
                ?.let { RoundCount(it) }
            requireNotNull(roundCount) { "유효한 입력 값이 아닙니다." }

            val racingRecordBoard = RacingRecordBoard()
            val racingGame = RacingGame(
                racingCarGarage = RacingCarGarage(
                    drivers = drivers,
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
            ResultView.printRaceResult(racingRecordBoard.results, racingRecordBoard.winners)
        }
    }
}
