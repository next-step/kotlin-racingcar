package racinggame.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racinggame.domain.car.CarName

class RacingGameControllerTest : BehaviorSpec({

    Given("자동차 이름과 게임 플레이 카운트가 주어졌을 때") {
        val racingGameInput = RacingGameInput(
            carNames = List(3) { CarName(value = it.toString()) },
            gamePlayCount = 3,
        )

        When("컨트롤러를 시작하면") {
            val mockRacingGameResultView = MockRacingGameResultView()
            val mockRacingGame = MockRacingGame(MockRacingGame.mockRacingGameResult())

            RacingGameController(
                MockRacingGameInputView(Result.success(racingGameInput)),
                mockRacingGameResultView,
                mockRacingGame,
            ).start()

            Then("입력된 데이터로 게임에 입장한다") {
                mockRacingGame.gameGuideCapture?.users?.map { it.carName } shouldBe racingGameInput.carNames
                mockRacingGame.gameGuideCapture?.gameRule?.playCount shouldBe racingGameInput.gamePlayCount
            }

            Then("레이싱 결과를 출력한다") {
                mockRacingGameResultView.racingGameResultCapture shouldBe mockRacingGame.mockRacingGameResult
            }
        }
    }
})
