package study.step3.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarFactoryTest : BehaviorSpec({

    Given("DefaultCarFactory 가 주입됬을때") {
        val carFactory = DefaultCarFactory()
        When("특정 수의 Car 객체를 생성할 경우") {
            val numberOfCars = 5
            val cars = carFactory.createCars(numberOfCars)
            Then("특정 수 만큼 객체가 생성된다.") {
                cars.size shouldBe numberOfCars
            }
            And("모든 Car 인스턴스의 초기 상태는 0이어야 한다") {
                cars.forEach { car ->
                    car.getVisualPosition() shouldBe ""
                }
            }
        }
    }
})
