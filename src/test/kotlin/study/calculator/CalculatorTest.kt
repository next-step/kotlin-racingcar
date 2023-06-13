package study.calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy

class CalculatorTest : StringSpec({

    "덧셈" {
        Calculator.calculate("6 + 3") shouldBe 9
        Calculator.calculate("1 + 2") shouldBe 3
        Calculator.calculate("9 + 2") shouldBe 11
        Calculator.calculate("0 + 9") shouldBe 9
    }

    "뺄셈" {
        Calculator.calculate("6 - 3") shouldBe 3
        Calculator.calculate("1 - 2") shouldBe -1
        Calculator.calculate("9 - 2") shouldBe 7
        Calculator.calculate("0 - 9") shouldBe -9
    }

    "곱셈" {
        Calculator.calculate("6 * 3") shouldBe 18
        Calculator.calculate("1 * 2") shouldBe 2
        Calculator.calculate("9 * 2") shouldBe 18
        Calculator.calculate("0 * 9") shouldBe 0
    }

    "나늣셈" {
        Calculator.calculate("6 / 3") shouldBe 2
        Calculator.calculate("1 / 2") shouldBe 0
        Calculator.calculate("9 / 2") shouldBe 4
        Calculator.calculate("0 / 9") shouldBe 0
    }

    "사칙연산 모두 포함" {
        Calculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }

    "입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 발생시킨다" {
        assertThatThrownBy { Calculator.calculate("2 + 3 @ 4 / 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("question was null or empty.")

        assertThatThrownBy { Calculator.calculate("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("question was null or empty.")
    }

    "사칙연산 기호가 아닌 경우 IllegalArgumentException을 발생시킨다" {
        assertThatThrownBy { Calculator.calculate("null") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("question allows only integer or +, -, * and /.")
    }
})
