package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.throwable.shouldHaveMessage

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

    Given("생성할 자동차 수가 음수이면") {
        val totalCarCount = -1

        When("자동차를 생성할 때") {
            val result = shouldThrow<IllegalArgumentException> {
                CarFactory.createCars(totalCarCount)
            }

            Then("IllegalArgumentException이 발생한다") {
                result shouldHaveMessage "Argument should be non negative number."
            }
        }
    }
})
