package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize

class CarFactoryTest : BehaviorSpec({
    Given("생성할 자동차 수가 주어졌을 때") {
        val totalCarCount = 3

        When("자동차를 생성하면") {
            val result = CarFactory.createCars(totalCarCount)

            Then("해당 수의 자동차 리스트가 반환된다") {
                result shouldHaveSize totalCarCount
            }
        }
    }
})
