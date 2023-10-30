package racingcar.domain.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class CarGeneratorTest : BehaviorSpec({
    Given("주어진 자동차 이름으로") {
        val names = listOf(CarName("test1"), CarName("test2"))
        When("자동차를 생성하면") {
            val result = CarGenerator.create(names)
            Then("이름 수만큼 자동차가 생성된다") {
                result.size shouldBe names.size
            }
            And("모든 자동차의 첫 위치는 0이다") {
                result.all { it.position == 0 }.shouldBeTrue()
            }
            And("전달된 이름으로 자동차가 생성된다") {
                result.forEachIndexed { index, car ->
                    car.name shouldBe names[index]
                }
            }
        }
    }
})
