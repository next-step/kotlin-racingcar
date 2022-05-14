package step2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    val calculator: Calculator = Calculator()

    "plus test" {
        calculator.calculate("1 + 1") shouldBe "2"
    }
})
