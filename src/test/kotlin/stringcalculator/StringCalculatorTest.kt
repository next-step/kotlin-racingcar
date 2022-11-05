package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "올바른 계산식 테스트" {
        StringCalculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }

    "NULL을 입력한 경우 예외 테스트" {
        shouldThrowExactly<IllegalArgumentException> { StringCalculator.calculate(null) }
    }

    "공백을 입력한 경우 예외 테스트" {
        shouldThrowExactly<IllegalArgumentException> { StringCalculator.calculate(" ") }
    }

    "사칙연산이 아닌 경우 예외 테스트" {
        shouldThrowExactly<IllegalArgumentException> { StringCalculator.calculate("1 + 2 % 3") }
    }
})
