package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class CarTest : BehaviorSpec({
    Given("5자를 초과하는 이름이 주어졌을 때") {
        val name = "aaaaaa"

        When("자동차를 생성하면") {
            val exception = shouldThrow<IllegalArgumentException> {
                Car(name = name)
            }

            Then("IllegalArgumentException이 발생한다") {
                exception shouldHaveMessage "Length of name should be no more than 5"
            }
        }
    }

    Given("자동차가 주어졌을 때") {
        val car = Car(name = "a")

        When("특정 양만큼 자동차를 이동시키면") {
            car.move(2)

            Then("자동차의 위치가 바뀐다") {
                car.position shouldBe 2
            }
        }
    }
})
