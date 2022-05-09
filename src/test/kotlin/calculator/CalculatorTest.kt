package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class CalculatorTest : DescribeSpec({
    describe("calculate") {
        context("2 + 3 * 4 / 2를 계산하면") {
            it("10이 반환된다") {
                val expression = Expression(
                    listOf(2, 3, 4, 2),
                    listOf(Operator.ADDITION, Operator.MULTIPLICATION, Operator.DIVISION)
                )
                Calculator.calculate(expression) shouldBe 10
            }
        }

        context("2 + 3 * 4 / 2를 계산하면") {
            it("10이 반환된다") {
                val expression = Expression(
                    listOf(2, 3, 4, 2),
                    listOf(Operator.ADDITION, Operator.MULTIPLICATION, Operator.DIVISION)
                )
                Calculator.calculate(expression) shouldBe 10
            }
        }

        context("2 * 3 / 4 - 2를 계산하면") {
            it("-1이 반환된다") {
                val expression = Expression(
                    listOf(2, 3, 4, 2),
                    listOf(Operator.MULTIPLICATION, Operator.DIVISION, Operator.SUBTRACTION)
                )
                Calculator.calculate(expression) shouldBe -1
            }
        }

        context("2 + 3 - 4 * 2를 계산하면") {
            it("2이 반환된다") {
                val expression = Expression(
                    listOf(2, 3, 4, 2),
                    listOf(Operator.ADDITION, Operator.SUBTRACTION, Operator.MULTIPLICATION)
                )
                Calculator.calculate(expression) shouldBe 2
            }
        }
    }
})
