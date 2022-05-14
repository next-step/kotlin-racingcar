package step2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    val calculator = Calculator()

    "plus test" {
        calculator.calculate("1 + 1") shouldBe 2
        calculator.calculate("1 + 2") shouldBe 3
        calculator.calculate("1 + 2 + 3") shouldBe 6
        calculator.calculate("1 + 2 + 3 + 4") shouldBe 10
    }

    "minus test" {
        calculator.calculate("1 - 1") shouldBe 0
        calculator.calculate("4 - 3 - 2") shouldBe -1
    }

    "multiply test" {
        calculator.calculate("2 * 2") shouldBe 4
        calculator.calculate("2 * 2 * 2") shouldBe 8
        calculator.calculate("2 * 2 * 2 * 10") shouldBe 80
        calculator.calculate("2 * 2 * 2 * -1") shouldBe -8
    }

    "divide test" {
        calculator.calculate("10 / 2") shouldBe 5
        calculator.calculate("4 / 2 / 2") shouldBe 1
        calculator.calculate("4 / 2 / 4") shouldBe 0.5
    }

    "calculate test" {
        calculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }
})
