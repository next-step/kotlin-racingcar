package calculator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CalculatorTest : StringSpec({

    "3 + 2 = 5" {
        Calculator().add(3, 2) shouldBe 5
    }

    "3 - 2 = 1" {
        Calculator().subtract(3, 2) shouldBe 1
    }

    "3 * 2 = 6" {
        Calculator().multiply(3, 2) shouldBe 6
    }

    "3 / 2 = 1" {
        Calculator().divide(3, 2) shouldBe 1
    }

    "4 / 2 = 2" {
        Calculator().divide(4, 2) shouldBe 2
    }

    "4 / 0 = ArithmeticException(\"/ by zero\")" {
        shouldThrowWithMessage<ArithmeticException>("/ by zero") {
            Calculator().divide(4, 0)
        }
    }
})
