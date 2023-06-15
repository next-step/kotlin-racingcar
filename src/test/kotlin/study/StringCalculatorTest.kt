package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    context("수식을 계산합니다") {
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
            "2 X 3" to "X",
            "2 % 3" to "%"
        ) { (input, operator) ->
            val stringCalculator = StringCalculator()
            val exception = shouldThrow<IllegalArgumentException> {
                stringCalculator.calculate(input)
            }
            exception.message shouldBe "${operator}는 지원하지 않는 연산자입니다."
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
