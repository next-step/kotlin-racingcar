package study

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
})