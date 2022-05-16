package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("Calculator") {
        it("연속된 연산식 연산을 수행한다.") {
            val calculator = Calculator()

            val result = calculator.calculate("10 + 2 - 2 * 2 / 2")

            result shouldBe 10
        }

        context("사칙연산 기호가 아닌 경우") {
            it("IllegalArgumentException 에러가 발생한다.") {

                val calculator = Calculator()

                val exception = shouldThrow<IllegalArgumentException> {
                    calculator.calculate("4 $ 2")
                }

                exception.message shouldBe "$ 은(는) 옵바른 사칙연산 기호가 아닙니다. (사용 가능 연산: + - * / )"
            }
        }

        context("입력값이 null 이거나 빈 공백 문자일 경우") {
            it("IllegalArgumentException 에러가 발생한다.") {
                val calculator = Calculator()

                val exception1 = shouldThrow<IllegalArgumentException> {
                    calculator.calculate("")
                }
                val exception2 = shouldThrow<IllegalArgumentException> {
                    calculator.calculate(null)
                }

                exception1.message shouldBe "입력값을 입력해주세요."
                exception2.message shouldBe "입력값을 입력해주세요."
            }
        }

        context("입력값이 공백을 포함하지 않은 경우") {
            it("IllegalArgumentException 에러가 발생한다.") {
                val calculator = Calculator()

                val exception = shouldThrow<IllegalArgumentException> {
                    calculator.calculate("1+2+3")
                }
                exception.message shouldBe "올바른 계산식이 아닙니다. 공백을 포함하여 다시 입력해주세요."
            }
        }
    }
})
