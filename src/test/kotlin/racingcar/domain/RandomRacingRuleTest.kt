package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.Racing

class RandomRacingRuleTest : BehaviorSpec({

    val alwaysForward = MovingCondition(5, 9, Racing.MOVE_FORWARD_CONDITION)
    val cantMove = MovingCondition(0, 3, Racing.MOVE_FORWARD_CONDITION)

    Given("RandomRacingRule 객체는") {
        val positiveRandomRacingRule = RandomRacingRule(condition = alwaysForward)
        When("4 이상의 정수가 나온다면") {
            Then("앞으로 전진할 수 있는지 확인하는 함수는 true를 반환한다.") {
                positiveRandomRacingRule.canMoveForward() shouldBe true
            }
        }

        val negativeRandomRacingRule = RandomRacingRule(condition = cantMove)
        When("4 미만의 정수가 나온다면") {
            Then("앞으로 전진할 수 있는지 확인하는 함수는 false를 반환한다.") {
                negativeRandomRacingRule.canMoveForward() shouldBe false
            }
        }
    }
})
