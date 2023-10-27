package calculator

import calculator.expression.StringExpression
import calculator.expression.StringExpressionTokenFactory
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    val stringExpressionTokenFactor = StringExpressionTokenFactory()
    val calculator = StringCalculator(stringExpressionTokenFactor)

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
                    val expression = StringExpression(it)

                    calculator.calculate(expression)
                }
            }
        }
    }

    context("test calculation") {
        test("add ") {
            val expression = StringExpression("2 + 3")

            val result = calculator.calculate(expression)

            result shouldBe 5
        }

        test("minus") {
            val expression = StringExpression("3 - 2")

            val result = calculator.calculate(expression)

            result shouldBe 1
        }

        test("multiply") {
            val expression = StringExpression("2 * 3")

            val result = calculator.calculate(expression)

            result shouldBe 6
        }

        test("divide") {
            val expression = StringExpression("6 / 3")

            val result = calculator.calculate(expression)

            result shouldBe 2
        }

        test("calculate with four operations") {
            forAll(
                row("2 + 3 * 4 / 2 - 5", 5),
                row("2 + 2 * 2 / 2 - 2", 2),
                row("2 + 10 * 3 / 3 - 2", 10),
            ) { input, result ->
                val expression = StringExpression(input)

                calculator.calculate(expression) shouldBe result
            }
        }
    }
})
