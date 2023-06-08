package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CapacityTest : BehaviorSpec({
    given("Capacity 객체는") {
        `when`("숫자를 인자로 전달하면") {
            val actual = Capacity(1)

            then("정상적으로 생성된다") {
                actual.value shouldBe 1
            }
        }

        `when`("음수를 인자로 전달하면") {
            then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> { Capacity(-1) }
            }
        }

        listOf("a", "CHAR", "", " ", null).forEach { testValue ->
            `when`("`$testValue` 을(를) 인자로 전달하면") {
                then("예외를 던진다.") {
                    shouldThrow<IllegalArgumentException> { Capacity(testValue) }
                }
            }
        }
    }
})
