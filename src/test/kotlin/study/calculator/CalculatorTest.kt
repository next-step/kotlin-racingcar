package study.calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy

class CalculatorTest : StringSpec({
    val calculator = Calculator()

    "덧셈" {
        calculator.calculate("6 + 3") shouldBe 9
        calculator.calculate("1 + 2") shouldBe 3
        calculator.calculate("9 + 2") shouldBe 11
        calculator.calculate("0 + 9") shouldBe 9
    }

    "뺄셈" {
        calculator.calculate("6 - 3") shouldBe 3
        calculator.calculate("1 - 2") shouldBe -1
        calculator.calculate("9 - 2") shouldBe 7
        calculator.calculate("0 - 9") shouldBe -9
    }

    "곱셈" {
        calculator.calculate("6 * 3") shouldBe 18
        calculator.calculate("1 * 2") shouldBe 2
        calculator.calculate("9 * 2") shouldBe 18
        calculator.calculate("0 * 9") shouldBe 0
    }

    "나늣셈" {
        calculator.calculate("6 / 3") shouldBe 2
        calculator.calculate("1 / 2") shouldBe 0
        calculator.calculate("9 / 2") shouldBe 4
        calculator.calculate("0 / 9") shouldBe 0
    }

    "사칙연산 모두 포함" {
        calculator.calculate("2 + 3 * 4 / 2") shouldBe 10

        assertThatThrownBy { calculator.calculate("2 + 3 @ 4 / 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("question was null or empty.")

        assertThatThrownBy { calculator.calculate("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("question was null or empty.")

        assertThatThrownBy { calculator.calculate("null") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("question allows only integer or +, -, * and /.")
    }
})
