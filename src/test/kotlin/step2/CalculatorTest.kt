package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    context("덧셈 테스트") {
        forAll(
            row("1 + 2", 3),
            row("10 + 20 + 30 + 40", 100),
        ) { input, expect ->
            val actual = InOrderCalculator().calculate(input)
            actual shouldBe expect
        }
    }

    context("뺄셈 테스트") {
        forAll(
            row("1 - 2", -1),
            row("100 - 2 - 10", 88),
        ) { input, expect ->
            val actual = InOrderCalculator().calculate(input)
            actual shouldBe expect
        }
    }

    context("곱셈 테스트") {
        forAll(
            row("1 * 2", 2),
            row("0 * 1", 0),
            row("5 * 10 * 3", 150),
        ) { input, expect ->
            val actual = InOrderCalculator().calculate(input)
            actual shouldBe expect
        }
    }

    context("나눗셈 테스트") {
        forAll(
            row("1 / 2", 0.5),
            row("60 / 2 / 3", 10),
        ) { input, expect ->
            val actual = InOrderCalculator().calculate(input)
            actual shouldBe expect
        }
    }

    context("복합된 사칙연산 테스트") {
        forAll(
            row("2 + 3 * 4 / 2", 10),
            row("5 / 2 - 1 * 3 + 0.5", 5),
        ) { input, expect ->
            val actual = InOrderCalculator().calculate(input)
            actual shouldBe expect
        }
    }

    context("입력값이 공백인 경우 예외") {
        forAll(
            row(" "),
            row(""),
        ) { input ->
            val exception = shouldThrow<IllegalArgumentException> {
                InOrderCalculator().calculate(input)
            }
            println(exception.message)
        }
    }

    context("입력값이 널인 경우 예외") {
        val input = null
        val exception = shouldThrow<IllegalArgumentException> {
            InOrderCalculator().calculate(input)
        }
        println(exception.message)
    }

    context("연산자가 올바르지 않은 경우 예외") {
        forAll(
            row("1 = 2"),
            row("100 % 5"),
            row("1 a 2"),
            row("1 1 1"),
        ) { input ->
            val exception = shouldThrow<IllegalArgumentException> {
                InOrderCalculator().calculate(input)
            }
            println(exception.message)
        }
    }

    context("식이 올바르지 않은 경우") {
        forAll(
            row("1 - - 2 3"),
            row("100 - 5 +"),
        ) { input ->
            val exception = shouldThrow<IllegalArgumentException> {
                InOrderCalculator().calculate(input)
            }
            println(exception.message)
        }
    }
})
