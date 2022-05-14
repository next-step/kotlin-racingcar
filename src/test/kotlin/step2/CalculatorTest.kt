package step2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    val calculator = Calculator()

    "plus test" {
        calculator.calculate("1 + 1") shouldBe "2"
        calculator.calculate("1 + 2") shouldBe "3"
        calculator.calculate("1 + 2 + 3") shouldBe "6"
        calculator.calculate("1 + 2 + 3 + 4") shouldBe "10"
    }

    "minus test" {
        calculator.calculate("1 - 1") shouldBe "0"
    }
})
