package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "계산기 테스트" {
        val calculator = Calculator("1 + 3 * 5 / 2")
        val value = calculator.calculate()
        value shouldBe Number(10)
    }

    "빈 수식 입력 시 오류 발생" {
        val exception = shouldThrow<IllegalArgumentException> {
            Calculator("")
        }
        exception.message shouldBe "수식을 입력해 주세요."
    }

    "순서가 맞지 않는 수식 입력 시 오류 발생" {
        val exception = shouldThrow<IllegalArgumentException> {
            Calculator("1 + 2 +")
        }
        exception.message shouldBe "수식의 마지막은 숫자여야 합니다."
    }
})
