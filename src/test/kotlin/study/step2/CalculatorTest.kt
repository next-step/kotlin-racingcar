package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "정상적인 식이 주어졌을 때 정상적으로 계산을 수행한다" {
        val result = Calculator.calculate("2 + 3 * 4 / 2")
        result shouldBe 10.0
    }
    "유효하지 않은 연산자가 포함된 식이 주어졌을 때 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("2 $ 3 * 4 / 2")
        }.message shouldBe "유효하지 않은 연산자입니다."
    }
    "숫자가 아닌 문자열이 포함된 경우 예외가 발생한다" {
        shouldThrow<NumberFormatException> {
            Calculator.calculate("One + Two")
        }.message shouldBe "유효한 숫자가 아닙니다."
    }
    "숫자와 연산자 사이의 공백이 여러 개인 경우 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate("1    + 2")
        }.message shouldBe "유효한 숫자가 아닙니다."
    }
})
