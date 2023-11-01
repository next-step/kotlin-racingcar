package racingcar.domain.game

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.configuration.CarRacingConfiguration
import racingcar.domain.rule.AlwaysMoveRule

class CarRacingGameTest : BehaviorSpec({
    Given("자동차 경주 게임이 생성되었을 때") {
        val carNames = listOf("name1", "name2")
        val roundCount = 2
        val game = CarRacingGame.set(
            configuration = CarRacingConfiguration.of(
                roundCount = roundCount,
                carNames = carNames,
                moveRule = AlwaysMoveRule(),
            ),
        )
        When("게임을 실행하면") {
            val result = game.run()
            Then("라운드 횟수만큼 라운드가 실행된다") {
                result.size shouldBe roundCount
            }
            And("라운드 별로 경기 결과가 기록된다") {
                result[0].cars[0].position shouldBe 1
                result[0].cars[1].position shouldBe 1
                result[1].cars[0].position shouldBe 2
                result[1].cars[1].position shouldBe 2
            }
        }
    }
})
