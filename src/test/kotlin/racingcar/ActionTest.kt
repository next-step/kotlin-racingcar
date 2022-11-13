package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.domain.Action

class ActionTest : BehaviorSpec({

    val (first, mid, last) = Triple(0, 4, 9)

    val stopConditions = (first until mid).map { it }
    Given("0이상 4미만인 숫자로") {
        When("액션을 취하려 하면") {
            Then("액션 타입이 STOP이다.") {
                stopConditions.forAll { num ->
                    Action.execute(num) shouldBe Action.Type.STOP
                }
            }
        }
    }

    val goConditions = (mid..last).map { it }
    Given("4이상 9이하인 숫자로") {
        When("액션을 취하려 하면") {
            Then("액션 타입이 GO이다.") {
                goConditions.forAll { num ->
                    Action.execute(num) shouldBe Action.Type.GO
                }
            }
        }
    }
})
