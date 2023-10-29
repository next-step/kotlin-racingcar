package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({
    context("calculator execute test") {
        data class Input(val expression: String, val result: Int)

        withData(
            Input("1 + 2", 3),
            Input("2 - 1", 1),
            Input("2 * 3", 6),
            Input("4 / 2", 2),
            Input("4 * 2 + 2 / 10", 1)
        ) { (expression, result) ->
            Calculator.execute(expression) shouldBe result
        }
    }
})
