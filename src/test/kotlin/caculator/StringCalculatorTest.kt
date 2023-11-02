package caculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    context("StringCalculator calculations") {
        listOf(
            "1 + 2 + 3" to 6,
            "2 + 3 * 4 / 2" to 10,
        ).forEach { (input, expected) ->
            test("calculate $input") {
                val result = StringCalculator().calculate(input)
                result shouldBe expected
            }
        }
    }

    context("StringCalculator operations") {
        listOf(
            Triple("1", "+", "2") to 3,
            Triple("1", "-", "2") to -1,
            Triple("1", "*", "2") to 2,
            Triple("2", "/", "1") to 2,
        ).forEach { (operands, expected) ->
            test("calculate ${operands.second}") {
                val (left, operator, right) = operands
                val result = StringCalculator().operate(left, operator, right)
                result shouldBe expected
            }
        }
    }
})
