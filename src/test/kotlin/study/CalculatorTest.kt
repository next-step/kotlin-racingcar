package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import org.assertj.core.api.Assertions.assertThat

class CalculatorTest : StringSpec({
    val calculator = Calculator()

    "덧셈" {
        listOf(
            "1 + 1 + 1 + 1" to 4,
            "1 + 2 + 3 + 0" to 6,
            "4 + 3 + 2 + -1" to 8,
            "2 + 3 + 4 + 2" to 11
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result)
        }
    }

    "뺄셈" {
        listOf(
            "1 - 1 - 1 - 1" to -2,
            "1 - 2 - 3 - 0" to -4,
            "4 - 1 - 2 - -1" to 2,
            "10 - 3 - 4 - 2" to 1
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result)
        }
    }

    "곱셈" {
        listOf(
            "1 * 1 * 1 * 2" to 2,
            "1 * 2 * 3 * 0" to 0,
            "4 * 1 * 2 * -1" to -8,
            "10 * 3 * 4 * 2" to 240
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result)
        }
    }

    "나눗셈" {
        listOf(
            "1 / 1" to 1,
            "1 / 0" to 0,
            "4 / 1" to 4
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result)
        }
    }

    "입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw" {
        listOf(
            "",
            " ",
            "   "
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                calculator.calc(it)
            }
        }
    }

    "사칙연산 기호가 아닌 경우 IllegalArgumentException throw" {
        listOf(
            "1 a 1 * 1 * 2",
            "1 * 2 b 3 * 0",
            "4 * 1 + 2 c -1",
            "10 / 3 + 4 D 2"
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                calculator.calc(it)
            }
        }
    }

    "사칙 연산을 모두 포함하는 기능 구현" {
        listOf(
            "2 + 3 * 4 / 2" to 10,
            "2 - 3 + 4 / 3 * 1" to 1,
            "2 * 5 / 2 + 2 - 1" to 6,
        ).forAll {
            assertThat(calculator.calc(it.first)).isEqualTo(it.second)
        }
    }
})