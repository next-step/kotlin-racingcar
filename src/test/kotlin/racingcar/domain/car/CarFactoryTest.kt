package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly

class CarFactoryTest : BehaviorSpec({
    Given("생성할 자동차 이름들이 주어졌을 때") {
        val names = listOf("a", "b")

        When("자동차를 생성하면") {
            val result = CarFactory.createCars(names)

            Then("해당 이름을 가진 자동차 리스트가 반환된다") {
                result shouldContainExactly listOf(Car(name = "a"), Car(name = "b"))
            }
        }
    }
})
