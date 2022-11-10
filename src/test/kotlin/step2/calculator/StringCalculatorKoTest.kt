package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringCalculatorKoTest : DescribeSpec({
    describe("복함 사칙 연산 테스트") {
        it("정상적인 입력값에 대한 테스트") {
            val input = "2 + 3 * 4 / 2"

            val calculateResult = StringCalculator.execute(input)
            calculateResult shouldBe 10
        }

        it("비정상적인 입력값에 대한 테스트") {
            val input = "2 + + 3 * 4 / 2"

            shouldThrow<NumberFormatException> {
                StringCalculator.execute(input)
            }
        }
    }
})
