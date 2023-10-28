package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class CarGeneratorTest : BehaviorSpec({
    Given("주어진 자동차 수로") {
        val count = 5
        When("자동차를 생성하면") {
            val result = CarGenerator.createInOrder(count)
            Then("해당 수만큼 자동차가 생성된다") {
                result.size shouldBe 5
            }
            And("모든 자동차의 첫 위치는 0이다") {
                result.all { it.position == 0 }.shouldBeTrue()
            }
            And("자동차의 순서대로 리스트에 담긴다") {
                result.forEachIndexed { index, car ->
                    car.order shouldBe index
                }
            }
        }
    }
})
