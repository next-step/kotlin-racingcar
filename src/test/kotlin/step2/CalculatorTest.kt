package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

class CalculatorTest : StringSpec({

    "invalid input" {
        val exception = shouldThrow<IllegalArgumentException> {
            calculate("")
            calculate(" ")
        }
        exception.message shouldStartWith("Invalid Input")
    }

    "invalid Operation Type" {
        val exception = shouldThrow<IllegalArgumentException> {
            calculate("1 & 1")
            calculate("1 1 1")
        }
        exception.message shouldStartWith("Invalid Operation Type")
    }

    "invalid Value Type" {
        val exceptionForValue = shouldThrow<IllegalArgumentException> {
            calculate("+ 1")
        }
        exceptionForValue.message shouldStartWith("Invalid Value Type")
    }

    "plus test" {
        calculate("1 + 1") shouldBe 2
        calculate("1 + 2") shouldBe 3
        calculate("1 + 2 + 3") shouldBe 6
        calculate("1 + 2 + 3 + 4") shouldBe 10
    }

    "minus test" {
        calculate("1 - 1") shouldBe 0
        calculate("4 - 3 - 2") shouldBe -1
    }

    "multiply test" {
        calculate("2 * 2") shouldBe 4
        calculate("2 * 2 * 2") shouldBe 8
        calculate("2 * 2 * 2 * 10") shouldBe 80
        calculate("2 * 2 * 2 * -1") shouldBe -8
    }

    "divide test" {
        calculate("10 / 2") shouldBe 5
        calculate("4 / 2 / 2") shouldBe 1
        calculate("4 / 2 / 4") shouldBe 0.5
    }

    "calculate test" {
        calculate("2 + 3 * 4 / 2") shouldBe 10
    }
})
