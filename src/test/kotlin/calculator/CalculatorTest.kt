package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "계산기 테스트" {
        val calculator = Calculator("1 + 3 * 5 / 2")
        val value = calculator.calculate()
        value shouldBe Number(10)
    }
})
