package study.racingcar.car

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarFactoryTest : BehaviorSpec({

    val moveGenerator = object : MoveGenerator {
        override fun canMove(): Boolean = false
    }

    Given("DefaultCarFactory 가 주입됬을때") {
        val carFactory = DefaultCarFactory()

        When("특정 수의 Car 객체를 생성할 경우") {
            val carNames = listOf("car1", "car2", "car3", "car4", "car5")
            val cars = carFactory.createCars(carNames, moveGenerator)

            Then("특정 수 만큼 객체가 생성된다.") {
                cars.size shouldBe carNames.size
            }

            And("모든 Car 인스턴스의 초기 상태는 0이어야 한다") {
                cars.forEach { car ->
                    car.getVisualPosition() shouldBe ""
                }
            }
        }
    }
})
