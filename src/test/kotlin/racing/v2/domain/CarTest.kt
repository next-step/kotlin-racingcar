package racing.v2.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class `자동차 프러퍼티 테스트` : StringSpec({
    "자동차 위치의 초기 값은 0이다." {
        val car = Car()
        car.position shouldBe 0
    }
})

class `자동차 전진 테스트` : BehaviorSpec({

    Given("자동차 객체가 주어질 때") {
        val 알렉스_자동차 = Car()

        When("임의의 수가 4 이상일 경우") {
            listOf(4, 5, 6, 7, 8, 9).forEach { number ->
                Then("자동차 위치는 1 증가한다.") {
                    val originPosition = 알렉스_자동차.position
                    알렉스_자동차.moveForward(CarDrivingPolicy, number)
                    알렉스_자동차.position shouldBe originPosition + 1
                }
            }
        }

        When("임의의 수가 3 이하일 경우") {
            listOf(1, 2, 3).forEach { number ->
                Then("자동차 위치는 기존과 동일하다") {
                    val originPosition = 알렉스_자동차.position
                    알렉스_자동차.moveForward(CarDrivingPolicy, number)
                    알렉스_자동차.position shouldBe originPosition
                }
            }
        }
    }
})
