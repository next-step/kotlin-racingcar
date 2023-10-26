package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    context("test validation") {
        test("calculate with invalid expression") {
            forAll(
                row(null),
                row(""),
                row(" "),
                row("1+"),
                row("1 +"),
                row("1 + 2 "),
                row("1 + 2 -"),
                row("1 + - 2"),
                row("1 2 - 2"),
            ) {
                shouldThrow<IllegalArgumentException> {
                    StringCalculator.calculate(it)
                }
            }
        }
    }

    context("test calculation") {
        test("add ") {
            val result = StringCalculator.calculate("2 + 3")

            result shouldBe 5
        }

        test("minus") {
            val result = StringCalculator.calculate("3 - 2")

            result shouldBe 1
        }

        test("multiply") {
            val result = StringCalculator.calculate("2 * 3")

            result shouldBe 6
        }

        test("divide") {
            val result = StringCalculator.calculate("6 / 3")

            result shouldBe 2
        }

        test("calculate with four operations") {
            forAll(
                row("2 + 3 * 4 / 2 - 5", 5),
                row("2 + 2 * 2 / 2 - 2", 2),
                row("2 + 10 * 3 / 3 - 2", 10),
            ) { expression, result ->
                StringCalculator.calculate(expression) shouldBe result
            }
        }
    }
})
