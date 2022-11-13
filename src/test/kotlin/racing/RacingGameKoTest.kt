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
import racing.model.RoundCount

internal class RacingGameKoTest : BehaviorSpec() {

    private lateinit var racingGame: RacingGame
    private lateinit var racingCarsFactory: RacingCarsFactory
    private lateinit var racingRecordBoard: RacingRecordBoard
    private lateinit var racingCar: RacingCar

    private var roundCount: RoundCount? = null
    private var carCount: CarCount? = null

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
            carCount = null
        }

        given("유저가 차량 3대, 시도횟수 5회 입력을 하였고") {
            beforeEach {
                carCount = CarCount(3)
                roundCount = RoundCount(5)
                racingGame = RacingGame(
                    racingCarGarage = RacingCarGarage(
                        carCount = requireNotNull(carCount),
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
                    racingRecordBoard.results.size shouldBe 5
                    racingRecordBoard.results.first().size shouldBe 3
                }
            }
        }
    }
}
