package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "올바른 계산식을 입력하면 정상적으로 계산된다" {
        StringCalculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }

    "NULL을 입력하면 예외가 발생한다" {
        shouldThrowExactly<IllegalArgumentException> { StringCalculator.calculate(null) }
    }

    "빈 공백을 입력하면 예외가 발생한다" {
        shouldThrowExactly<IllegalArgumentException> { StringCalculator.calculate(" ") }
    }

    "지원하지 않는 연산자를 입력하면 예외가 발생한다" {
        shouldThrowExactly<IllegalArgumentException> { StringCalculator.calculate("1 + 2 % 3") }
    }
})
