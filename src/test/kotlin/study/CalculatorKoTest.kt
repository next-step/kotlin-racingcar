package study

import Calculator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorKoTest : StringSpec({
    "덧셈" {
        Calculator.plus("2", "3") shouldBe "5"
    }
    "뺄셈" {
        Calculator.minus("5", "3") shouldBe "2"
    }
    "곱셈" {
        Calculator.times("2", "3") shouldBe "6"
    }
    "나눗셈" {
        Calculator.divide("6", "3") shouldBe "2"
    }
    "계산식 테스트" {
        Calculator.calculate("2 + 3 * 4 / 2") shouldBe "10"
        // cal.calculate("2 + 3 * 4 /") shouldBe "10"
    }
})
