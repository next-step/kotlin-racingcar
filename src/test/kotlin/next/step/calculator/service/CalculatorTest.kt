package next.step.calculator.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({
    context("주어진 수식을 계산하여 반환") {
        data class CalculationExpected(val command: String, val expected: Int)
        withData(
            nameFn = { "${it.command} = ${it.expected}" },
            CalculationExpected("4 / 2", 2),
            CalculationExpected("4 - 2 * 5", 10),
            CalculationExpected("2 + 3 * 4 / 2", 10),
            CalculationExpected("24 / 4 * 2 - 10 + 7", 9),
        ) { (command, expected) ->
            Calculator.calculate(command) shouldBe expected
        }
    }
})
