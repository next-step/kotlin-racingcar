package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.DescribeSpec
import org.assertj.core.api.Assertions.assertThat

class CalculatorKoTestBehavior : BehaviorSpec({
    Given("계산기 객체가 주어지고") {
        When("2 + 3 * 4 / 2 문자열 입력된 경우") {
            val actual = execute("2 + 3 * 4 / 2")

            Then("사칙연산 순서와 관계 없이 입력 순서대로 10이 반환된다") {
                assertThat(actual).isEqualTo(10)
            }
        }
    }
})

class CalculatorKoTestDescribe : DescribeSpec({
    describe("계산기 객체가 주어지고") {
        context("2 + 3 * 4 / 2 문자열 입력된 경우") {
            val actual = execute("2 + 3 * 4 / 2")

            it("사칙연산 순서와 관계 없이 입력 순서대로 10이 반환된다") {
                assertThat(actual).isEqualTo(10)
            }
        }
    }
})
