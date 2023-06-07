package study

import Calculator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorKoTest : StringSpec({
    "덧셈" {
        val cal = Calculator()
        cal.plus("2", "3") shouldBe "5"
    }
    "뺄셈" {
        val cal = Calculator()
        cal.minus("5", "3") shouldBe "2"
    }
    "곱셈" {
        val cal = Calculator()
        cal.multiple("2", "3") shouldBe "6"
    }
    "나눗셈" {
        val cal = Calculator()
        cal.divide("6", "3") shouldBe "2"
    }
    "계산식 테스트" {
        val cal = Calculator()
        cal.calculate("2 + 3 * 4 / 2") shouldBe "10"
        // cal.calculate("2 + 3 * 4 /") shouldBe "10"
    }
})