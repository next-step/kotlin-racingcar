package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorKoTest : DescribeSpec({
    describe("calculate method") {
        forAll(
            row("7", 7),
            row("3+5", 8),
            row("1+2+3/3", 2.0f),
            row("27/5", 5.4f),
            row("27  /    5", 5.4f),
        ) { expression, expect ->
            context("with $expression") {
                it("returns $expect") {
                    Calculator.calculate(expression) shouldBe expect
                }
            }
        }

        forAll(
            row(""),
            row("    "),
            row("수식이 아니다"),
            row("No"),
            row("1++2**3"),
            row("1 + + 2 * * 3"),
        ) { expression ->
            context("with wrong expression : ( $expression )") {
                it("throws IllegalArgumentException") {
                    shouldThrow<IllegalArgumentException> {
                        Calculator.calculate(expression)
                    }
                }
            }
        }
    }
})
