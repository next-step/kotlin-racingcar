package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racing.domain.FakeRandomMovingCarConditionNumber
import racing.domain.GoOrStopCarAction
import racing.domain.GoOrStopCarActionImpl
import racing.domain.RacingCarsFactory
import racing.domain.RacingCarsFactoryImpl
import racing.model.CarCount
import racing.model.RoundCount

internal class RacingGameKoTest : BehaviorSpec() {

    private lateinit var racingGame: RacingGame
    private lateinit var racingCarsFactory: RacingCarsFactory
    private lateinit var goOrStopCarAction: GoOrStopCarAction

    init {
        beforeEach {
            racingCarsFactory = RacingCarsFactoryImpl()
            goOrStopCarAction = GoOrStopCarActionImpl(
                randomMovingCarConditionNumber = FakeRandomMovingCarConditionNumber()
            )
        }

        given("유저가 차량 3대, 시도횟수 5회 입력을 하였고") {
            beforeEach {
                racingGame = RacingGame(
                    roundCount = RoundCount(5),
                    racingCarGarage = RacingCarGarage(
                        carCount = CarCount(3),
                        racingCarsFactory = racingCarsFactory
                    ),
                    goOrStopCarAction = goOrStopCarAction
                )
            }
            `when`("경주를 시작하였을 때") {
                beforeEach {
                    racingGame.race()
                }
                then("차량 3대의 5 라운드 경주 결과를 확인 할 수 있다.") {
                    racingGame.results.size shouldBe 5
                    racingGame.results[0].size shouldBe 3
                }
            }
        }
    }
}
