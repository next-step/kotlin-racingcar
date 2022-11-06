package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class CalculatorTest : FunSpec({
    context("올바른 데이터의 계산을 진행한다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                "2 + 2" to 4.0,
                "4 / 2 + 1" to 3.0,
                "5 * 4 / 4" to 5.0
            )
        ) { (rawString, result) ->
            Calculator.calculate(rawString) shouldBe result
        }
    }
})
