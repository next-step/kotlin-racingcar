package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class NameTest : BehaviorSpec({
    Given("Name 객체를 생성할 때") {
        When("5글자 이내의 문자열을 전달하면") {
            val actual = Name("12345")

            Then("정상적으로 생성된다") {
                actual shouldBe Name("12345")
            }
        }

        When("5글자 이상의 문자열을 전달하면") {
            Then("예외를 던진다") {
                assertThrows<IllegalArgumentException> {
                    Name("123456")
                }
            }
        }
    }
})
