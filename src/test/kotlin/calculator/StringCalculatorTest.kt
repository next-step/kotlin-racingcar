package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    context("사칙연산") {
        test("덧셈") {
            StringCalculator.calculate("1 + 2") shouldBe 3
        }
        test("뺄셈") {
            StringCalculator.calculate("1 - 2") shouldBe -1
        }
        test("곱셈") {
            StringCalculator.calculate("3 * 2") shouldBe 6
        }
        test("나눗셈") {
            StringCalculator.calculate("6 / 2") shouldBe 3
        }
        test("사칙 연산을 모두 포함") {
            StringCalculator.calculate("6 / 2 + 20 - 4 * 10") shouldBe 190
        }
    }

    context("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { if (it == null) "input : $it" else "input : \"${it}\"" },
            null,
            "",
            "         ",
        ) { input ->
            val exception = shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate(input)
            }
            exception.localizedMessage shouldBe "입력값이 null 또는 빈 문자열일 수 없습니다."
        }
    }

    context("사칙연산 기호가 아닌 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "input : $it" },
            "2 = 5",
            "2 a 5",
            "2 ^ 5",
            "2 + 3 * 4 1 2 "
        ) { input ->
            val exception = shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate(input)
            }
            exception.localizedMessage shouldBe "사용 가능한 사칙연산 기호는 [+, -, *, /]입니다."
        }
    }
})
