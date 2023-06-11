package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({
    Given("객체를 생성할 때") {
        When("0 이상의 Capacity를 전달하면") {
            val actual = Cars(capacity = Capacity(1))

            Then("정상적으로 생성된다") {
                actual shouldHaveSize 1
            }
        }

        When("0인 Capacity를 전달하면") {
            Then("예외를 던진다") {
                shouldThrow<IllegalArgumentException> {
                    Cars(capacity = Capacity.ZERO)
                }
            }
        }
    }

    Given("이동 알림을 요청할 때 ") {
        When("무조건 전진 전략을 제공하면") {
            val cars = Cars(capacity = Capacity(5))
            cars.notifyMoving { DirectionType.STRAIGHT }

            Then("모든 자동차는 전진한다.") {
                val actual = cars.associateBy({ it.id }, { it.distance })

                actual.forEach {
                    it.value shouldBe Distance(1L)
                }
            }
        }

        When("무조건 멈춤 전략을 제공하면") {
            val cars = Cars(capacity = Capacity(5))
            cars.notifyMoving { DirectionType.STOP }

            Then("모든 자동차는 멈춰있다.") {
                val actual = cars.associateBy({ it.id }, { it.distance })

                actual.forEach {
                    it.value shouldBe Distance.ZERO
                }
            }
        }
    }

    Given("map으로 변경하려 할 때") {
        val cars = Cars(capacity = Capacity(5))

        When("유효한 키 선택자와 값 선택자를 전달하면") {
            val actual = cars.associateBy({ it.id }, { it.distance })

            Then("유효한 맵 자료구조를 반환한다.") {
                (0 until 5).forEach {
                    actual[it] shouldBe Distance.ZERO
                }
            }
        }
    }
})
