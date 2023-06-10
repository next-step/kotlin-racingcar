package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest : FreeSpec({
    "덧셈" {
        forAll(
            row("1 + 2", 3),
            row("-1 + 9999999", 9999998)
        ) { input, expected ->
            val result = Calculator.calculate(input)
            result shouldBe expected
        }
    }
    "뺄셈" {
        forAll(
            row("1 - 2", -1),
            row("1 - 999999", -999998)
        ) { input, expected ->
            val result = Calculator.calculate(input)
            result shouldBe expected
        }
    }

    "기호 검증 - 예외 처리" {
        forAll(
            row("1 4 2"),
            row("1 # 2"),
            row("1 / 0")
        ) { input ->
            shouldThrow<IllegalArgumentException> { Calculator.calculate(input) }
        }
    }

    "곱셈" {
        forAll(
            row("1 * 100000", 100000),
            row("-100 * -100", 10000),
        ) { input, expected ->

            val result = Calculator.calculate(input)
            result shouldBe expected
        }
    }
    "나눗셈" {
        forAll(
            row("100000 / 2", 50000),
            row("-100 / -100", 1),
            row("50 / 4", 12.5)
        ) { input, expected ->
            val result = Calculator.calculate(input)
            result shouldBe expected
        }
    }
})
