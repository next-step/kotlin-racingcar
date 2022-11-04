package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.throwable.shouldHaveMessage
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
            assertThat(calculator.calc(formula)).isEqualTo(result.toDouble())
        }
    }

    "뺄셈" {
        listOf(
            "1 - 1 - 1 - 1" to -2,
            "1 - 2 - 3 - 0" to -4,
            "4 - 1 - 2 - -1" to 2,
            "10 - 3 - 4 - 2" to 1
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result.toDouble())
        }
    }

    "곱셈" {
        listOf(
            "1 * 1 * 1 * 2" to 2,
            "1 * 2 * 3 * 0" to 0,
            "4 * 1 * 2 * -1" to -8,
            "10 * 3 * 4 * 2" to 240
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result.toDouble())
        }
    }

    "나눗셈" {
        listOf(
            "1 / 1" to 1,
            "3 / 1" to 3,
            "1 / 3" to 0.3333333333333333,
            "10 / 20" to 0.5,
            "1 / 4" to 0.25
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result.toDouble())
        }
    }

    "주어진 값이 0으로 나눗셈을, 계산할때, 에러가 발생한다" {
        listOf(
            "0 / 0",
            "1 / 0"
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                calculator.calc(it)
            }.shouldHaveMessage("분모는 0이 될 수 없습니다")
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
            assertThat(calculator.calc(it.first)).isEqualTo(it.second.toDouble())
        }
    }

    "순서가 맞지 않는 계산식이 주어지고, 사칙연산 계산을 진행하하면, 예외가 발생한다" {
        listOf(
            "1 1 + 3 + 3",
            "1 + 1 + 3 3",
            "1 + 1 3 + 3"
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                calculator.calc(it)
            }.shouldHaveMessage("계산식의 순서가 맞지 않습니다")
        }
    }
})
