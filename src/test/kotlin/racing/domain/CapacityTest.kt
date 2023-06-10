package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CapacityTest : BehaviorSpec({
    Given("Capacity 객체 생성자는") {
        When("숫자를 인자로 전달하면") {
            val actual = Capacity(1)

            Then("정상적으로 생성된다") {
                actual.value shouldBe 1
            }
        }

        When("음수를 인자로 전달하면") {
            Then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> { Capacity(-1) }
            }
        }

        listOf("a", "CHAR", "", " ", null).forEach { testValue ->
            When("`$testValue` 을(를) 인자로 전달하면") {
                Then("예외를 던진다.") {
                    shouldThrow<IllegalArgumentException> { Capacity(testValue) }
                }
            }
        }
    }

    Given("Capacity 객체는") {
        When("유효한 값으로 생성한 경우") {
            val actual = Capacity(10)

            Then("for-in 구문을 사용할 수 있다") {
                actual.forEachIndexed { idx, value ->
                    idx shouldBe value
                }
            }

            Then("비교 연산이 가능하다") {
                val greatThanTarget = Capacity(11)
                val lessThanTarget = Capacity(9)
                val equalTarget = Capacity(10)

                actual shouldBeGreaterThan lessThanTarget
                actual shouldBe equalTarget
                actual shouldBeLessThan greatThanTarget
            }
        }
    }
})
