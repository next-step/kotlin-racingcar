package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CalculatorTest : StringSpec({
    "사칙 연산 계산" {
        val rawExpress = "2 + 3 * 4 / 2" // 10

        val result = Calculator().calculate(rawExpress)

        result shouldBe 10.0
    }
})
