package step2.calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("이항식") {
        forAll(
            row("8 + 4", 12),
            row("8 - 4", 4),
            row("8 * 4", 32),
            row("8 / 4", 2)
        ) { input, expectResult ->
            // given
            val calculator = Calculator()

            // when
            val result = calculator.execute(input)

            // then
            result shouldBe expectResult
        }
    }

    describe("삼항식") {
        it("모두 같은 연산자") {
            forAll(
                row("8 + 4 + 2", 14),
                row("8 - 4 - 2", 2),
                row("8 * 4 * 2", 64),
                row("8 / 4 / 2", 1)
            ) { input, expectResult ->
                // given
                val calculator = Calculator()

                // when
                val result = calculator.execute(input)

                // then
                result shouldBe expectResult
            }
        }

        it("모두 다른 연산자") {
            forAll(
                row("8 + 4 - 2", 10),
                row("8 - 4 * 2", 8),
                row("8 * 4 / 2", 16),
                row("8 / 4 + 2", 4)
            ) { input, expectResult ->
                // given
                val calculator = Calculator()

                // when
                val result = calculator.execute(input)

                // then
                result shouldBe expectResult
            }
        }
    }
})
