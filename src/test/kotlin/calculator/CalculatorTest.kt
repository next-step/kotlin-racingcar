package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class CalculatorTest : FunSpec({
    context("올바른 계산을 진행할 수 있다.") {
        withData(
            "1 + 100" to 101.0,
            "3 / 2 + 1 * 3" to 7.5,
            "10 / 2 * 10 + 1 - 1" to 50.0
        ) { (rewExpression, result) ->
            Calculator.execute(rewExpression) shouldBe result
        }
    }
})
