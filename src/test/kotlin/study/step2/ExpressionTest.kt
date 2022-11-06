package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.throwable.shouldHaveMessage

class ExpressionTest : StringSpec({

    "입력값이 null이거나 빈 공백 문자일 경우, 계산하면, 예외가 발생한다" {
        listOf(
            "",
            " ",
            "   "
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                Expression.valid(it)
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
                Expression.valid(it)
            }.shouldHaveMessage("올바르지 않은 사칙연산 기호입니다")
        }
    }

    "순서가 맞지 않는 계산식이 주어지고, 사칙연산 계산을 진행하하면, 예외가 발생한다" {
        listOf(
            "1 1 + 3 + 3",
            "1 + 1 + 3 3",
            "1 + 1 3 + 3"
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                Expression.valid(it)
            }.shouldHaveMessage("계산식의 순서가 맞지 않습니다")
        }
    }

    "마지막 순서가 숫자가 아닌 계산식이 주어지고, 사칙연산 계산을 진행하하면, 예외가 발생한다" {
        listOf(
            "1 + 3 +",
            "1 + 1 -",
            "1 + 1 / 3 +"
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                Expression.valid(it)
            }.shouldHaveMessage("계산식이 올바르지 않습니다")
        }
    }
})
