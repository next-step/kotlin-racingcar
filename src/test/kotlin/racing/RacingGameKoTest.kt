package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racing.domain.GoOrStopCarActionImpl
import racing.domain.RacingCar
import racing.domain.RacingCarImpl
import racing.domain.RacingCarsFactory
import racing.domain.RacingCarsFactoryImpl
import racing.domain.RandomMoveStrategy
import racing.model.CarCount
import racing.model.Driver
import racing.model.RoundCount

internal class RacingGameKoTest : BehaviorSpec() {

    private lateinit var racingGame: RacingGame
    private lateinit var racingCarsFactory: RacingCarsFactory
    private lateinit var racingRecordBoard: RacingRecordBoard
    private lateinit var racingCar: RacingCar

    private var roundCount: RoundCount? = null

    init {
        beforeEach {
            racingCarsFactory = RacingCarsFactoryImpl()
            racingRecordBoard = RacingRecordBoard()
            racingCar = RacingCarImpl(
                goOrStopCarAction = GoOrStopCarActionImpl(
                    moveStrategy = RandomMoveStrategy()
                )
            )
        }

        afterEach {
            roundCount = null
        }

        given("드라이버 세 명과, 시도횟수 5회 입력을 하였고") {
            val round = 5
            val drivers = listOf("똘기", "떵이", "호치", "새초미")
            beforeEach {
                roundCount = RoundCount(round)
                racingGame = RacingGame(
                    racingCarGarage = RacingCarGarage(
                        drivers = drivers.map { Driver(it) },
                        racingCarsFactory = racingCarsFactory
                    ),
                    racingCar = racingCar
                )
            }
            `when`("경주를 시작하였을 때") {
                beforeEach {
                    repeat(requireNotNull(roundCount).value) {
                        val result = racingGame.race()
                        racingRecordBoard.add(result)
                    }
                }
                then("차량 3대의 5 라운드 경주 결과를 확인 할 수 있다.") {
                    racingRecordBoard.results.size shouldBe round
                    racingRecordBoard.results.first().result.size shouldBe drivers.size
                }
            }
        }
    }
}
