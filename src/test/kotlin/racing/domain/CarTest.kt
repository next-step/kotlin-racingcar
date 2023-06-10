package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({
    Given(name = "자동차 객체가 전진을") {
        When(name = "단일 수행하고 전진 조건이 STRAIGHT를 반환하면") {
            val actual = Car(id = 1).apply { move { DirectionType.STRAIGHT } }

            Then(name = "위치 정보는 증가한다.") {
                actual shouldBe Car(id = 1, distance = Distance(1L))
            }
        }

        When(name = "단일 수행하고 전진 조건이 false를 반환하면") {
            val actual = Car(id = 1).apply { move { DirectionType.STOP } }

            Then(name = "위치 정보는 그대로 유지된다.") {
                actual shouldBe Car(id = 1, distance = Distance.ZERO)
            }
        }

        When("여러번 수행하고 전진 조건이 true를 반환하면") {
            val actual = Car(id = 1).apply {
                move { DirectionType.STRAIGHT }
                move { DirectionType.STRAIGHT }
            }

            Then(name = "위치 정보는 수행한 만큼 증가한다.") {
                actual shouldBe Car(id = 1, distance = Distance(2))
            }
        }
    }

    Given("자동차 객체가 위치 값을 비교할 때") {
        val source = Car(id = 1, distance = Distance(10L))

        When("더 멀리 이동한 자동차와 비교할 경우") {
            val target = Car(id = 1, distance = Distance(20L))

            val actual: Int = source compareTo target

            Then("음수를 반환한다") {
                actual shouldBeLessThan 0
            }
        }

        When("더 적게 이동한 자동차와 비교할 경우") {
            val target = Car(id = 1, distance = Distance(5L))

            val actual: Int = source compareTo target

            Then("양수를 반환한다") {
                actual shouldBeGreaterThan 0
            }
        }

        When("동일하게 이동한 자동차와 비교할 경우") {
            val target = Car(id = 1, distance = Distance(10L))

            val actual: Int = source compareTo target

            Then("0dmf 반환한다") {
                actual shouldBe 0
            }
        }
    }
})
