package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorKoTestBehavior : BehaviorSpec({
    Given("정상적인 입력값이 주어질 때") {
        Then("사칙 연산 우선 순서 상관 없이 입력 값 순서대로 계산되어 반환한다") {
            execute("2 + 3 * 4 / 2") shouldBe 10
        }
    }

    Given("비정상적인 입력값이 주어질 때") {
        When("입력값이 null이거나 빈 공백 문자일 경우") {
            Then("IllegalArgumentException 예외를 던진다") {
                shouldThrow<IllegalArgumentException> {
                    execute("")
                }.message shouldBe "입력값을 제대로 기입해주세요."
            }
        }
        When("사칙연산 기호가 아닌 경우") {
            Then("IllegalArgumentException 예외를 던진다") {
                shouldThrow<IllegalArgumentException> {
                    execute("2 & 7")
                }.message shouldBe "입력값은 숫자와 사칙연산('+', '-', '*', '/')만 기입해주세요."
            }
        }
        When("첫번째 입력값이 숫자가 아닌 경우") {
            Then("IllegalArgumentException 예외를 던진다") {
                shouldThrow<IllegalArgumentException> {
                    execute("& 7")
                }.message shouldBe "입력값은 숫자와 사칙연산('+', '-', '*', '/')만 기입해주세요."
            }
        }
    }
})

class CalculatorKoTestDescribe : DescribeSpec({
    describe("계산기 객체가 주어지고") {
        context("2 + 3 * 4 / 2 문자열 입력된 경우") {
            it("사칙연산 순서와 관계 없이 입력 순서대로 10이 반환된다") {
                execute("2 + 3 * 4 / 2") shouldBe 10
            }
        }
    }
})
