package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.Racing

class RacingRuleTest : BehaviorSpec({

    val intRandomGenerator = { start: Int, end: Int -> IntRange(start, end).random() }
    val stubValidation = { _: List<String> -> true }
    val alwaysForward = RacingProperty(5, 9, Racing.MOVE_FORWARD_CONDITION)
    val cantMove = RacingProperty(0, 3, Racing.MOVE_FORWARD_CONDITION)

    Given("RacingRule 객체는") {
        val positiveRacingRule = RacingRule(intRandomGenerator, stubValidation, alwaysForward)
        When("4 이상의 정수가 나온다면") {
            Then("앞으로 전진할 수 있는지 확인하는 함수는 true를 반환한다.") {
                positiveRacingRule.canMoveForward() shouldBe true
            }
        }

        val negativeRacingRule = RacingRule(intRandomGenerator, stubValidation, cantMove)
        When("4 미만의 정수가 나온다면") {
            Then("앞으로 전진할 수 있는지 확인하는 함수는 false를 반환한다.") {
                negativeRacingRule.canMoveForward() shouldBe false
            }
        }
    }
})
