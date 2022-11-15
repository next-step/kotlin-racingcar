package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racing.domain.GoOrStopCarActionImpl
import racing.domain.Racing
import racing.domain.RacingCarsFactory
import racing.domain.RacingCarsFactoryImpl
import racing.domain.RacingImpl
import racing.domain.RandomMoveStrategy
import racing.model.Driver
import racing.model.RoundCount

internal class RacingGameKoTest : BehaviorSpec() {

    private lateinit var racingGame: RacingGame
    private lateinit var racingCarsFactory: RacingCarsFactory
    private lateinit var racingRecordBoard: RacingRecordBoard
    private lateinit var racing: Racing

    init {
        beforeEach {
            racingCarsFactory = RacingCarsFactoryImpl()
            racingRecordBoard = RacingRecordBoard()
            racing = RacingImpl(
                goOrStopCarAction = GoOrStopCarActionImpl(
                    moveStrategy = RandomMoveStrategy()
                )
            )
        }

        given("드라이버 4 명과, 시도횟수 5회 입력을 하였고") {
            val roundCount = RoundCount(5)
            val drivers = listOf("똘기", "떵이", "호치", "새초미").map { Driver(it) }
            `when`("경주를 시작하였을 때") {
                beforeEach {
                    racingGame = RacingGame(
                        inputView = InputView,
                        resultView = ResultView,
                        racingCarGarage = RacingCarGarage(
                            racingCarsFactory = racingCarsFactory
                        ),
                        racing = racing,
                        racingRecordBoard = racingRecordBoard
                    )
                    racingGame.start(drivers, roundCount)
                }
                then("차량 3대의 5 라운드 경주 결과를 확인 할 수 있다.") {
                    racingRecordBoard.results.size shouldBe roundCount.value
                    racingRecordBoard.results.first().result.size shouldBe drivers.size
                }
            }
        }
    }
}
