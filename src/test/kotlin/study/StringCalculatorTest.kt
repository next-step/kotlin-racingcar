package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    context("문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다") {
        withData(
            "2 + 3 * 4 / 2" to 10,
            "3 + 3 * 4 / 2" to 12,
        ) { (input, expected) ->
            val stringCalculator = StringCalculator()
            stringCalculator.calculate(input) shouldBe expected
        }
    }

    context("사칙연산 기호가 아닌 경우 IllegalArgumentException throw") {
        withData(
            "+" to true,
            "-" to true,
            "*" to true,
            "/" to true,
            "X" to false,
            "%" to false,
        ) { (operator, expected) ->
            val stringCalculator = StringCalculator()
            if (expected) {
                stringCalculator.getOperator(operator)
            } else {
                val exception = shouldThrow<IllegalArgumentException> {
                    stringCalculator.getOperator(operator)
                }
                exception.message shouldBe "${operator}는 지원하지 않는 연산자입니다."
            }
        }
    }

    context("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw") {
        forAll(
            row(null),
            row(""),
        ) { input ->
            val stringCalculator = StringCalculator()
            val exception = shouldThrow<IllegalArgumentException> {
                stringCalculator.calculate(input)
            }
            exception.message shouldBe "입력값이 null이거나 빈 공백 문자입니다."
        }
    }
})
