package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat

class CalculatorTest : StringSpec({
    lateinit var calculator: Calculator

    beforeSpec() {
        calculator = Calculator()
    }

    "계산식이 덧셈만 있을때, 계산을 하면, 올바른 결과가 나온다" {
        listOf(
            "1 + 1 + 1 + 1" to 4,
            "1 + 2 + 3 + 0" to 6,
            "4 + 3 + 2 + -1" to 8,
            "2 + 3 + 4 + 2" to 11
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result)
        }
    }

    "계산식이 뺄셈만 있을때, 계산을 하면, 올바른 결과가 나온다" {
        listOf(
            "1 - 1 - 1 - 1" to -2,
            "1 - 2 - 3 - 0" to -4,
            "4 - 1 - 2 - -1" to 2,
            "10 - 3 - 4 - 2" to 1
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result)
        }
    }

    "계산식이 곱셈만 있을때, 계산을 하면, 올바른 결과가 나온다" {
        listOf(
            "1 * 1 * 1 * 2" to 2,
            "1 * 2 * 3 * 0" to 0,
            "4 * 1 * 2 * -1" to -8,
            "10 * 3 * 4 * 2" to 240
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result)
        }
    }

    "계산식이 나눗셈만 있을때, 계산을 하면, 내림처리로 처리된 결과가 나온다" {
        listOf(
            "1 / 1" to 1,
            "3 / 1" to 3,
            "1 / 3" to 0,
            "10 / 20" to 0,
            "1 / 4" to 0
        ).forAll { (formula, result) ->
            assertThat(calculator.calc(formula)).isEqualTo(result)
        }
    }

    "나눗셈시 분모가 0으로, 계산할때, 에러가 발생한다" {
        listOf(
            "0 / 0",
            "1 / 0"
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                calculator.calc(it)
            }.shouldHaveMessage("분모는 0이 될 수 없습니다")
        }
    }

    "입력값이 null이거나 빈 공백 문자일 경우, 계산하면, 예외가 발생한다" {
        listOf(
            "",
            " ",
            "   "
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                calculator.calc(it)
            }.shouldHaveMessage("입력값이 null이거나 빈 공백 문자가 될 수 없습니다")
        }
    }

    "사칙연산 기호가 아닌 계산식이 주어진경우, 계산하면, 예외가 발생한다" {
        listOf(
            "1 a 1 * 1 * 2",
            "1 * 2 b 3 * 0",
            "4 * 1 + 2 c -1",
            "10 / 3 + 4 D 2"
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                calculator.calc(it)
            }.shouldHaveMessage("올바르지 않은 사칙연산 기호입니다")
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
