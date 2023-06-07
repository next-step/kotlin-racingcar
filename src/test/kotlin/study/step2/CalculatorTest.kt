package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "정상적인 식이 주어졌을 때 계산기가 정상적으로 계산을 수행한다" {
        val formula = Formula("2 + 3 * 4 / 2")
        val result = Calculator.calculate(formula)
        result shouldBe 10.0
    }
    "유효하지 않은 연산자가 포함된 식이 주어졌을 때 예외가 발생한다" {
        val formula = Formula("2 $ 3 * 4 / 2")
        shouldThrow<IllegalArgumentException> {
            Calculator.calculate(formula)
        }.message shouldBe "유효하지 않은 연산자입니다."
    }
})
