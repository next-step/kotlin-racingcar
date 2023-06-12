package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CalculatorTest : StringSpec({

    "덧셈" {
        Calculator.execute("1 + 1") shouldBe 2.0
        Calculator.execute("     1 + 1") shouldBe 2.0
        Calculator.execute("2 + 5 + 3") shouldBe 10.0
        Calculator.execute("4 + 2 + 3 + 10 + 24 + 1") shouldBe 44.0
        Calculator.execute("10 + 10000") shouldBe 10010.0
    }

    "뺄셈" {
        Calculator.execute("10 - 3") shouldBe 7.0
        Calculator.execute("100 - 20 - 1") shouldBe 79.0
        Calculator.execute("2 - 3 - 1") shouldBe -2.0
        Calculator.execute("10000000 - 100000") shouldBe 9900000.0
    }

    "곱셈" {
        Calculator.execute("2 * 3") shouldBe 6.0
        Calculator.execute("4 * 5 * 30") shouldBe 600.0
    }

    "나눗셈" {
        Calculator.execute("5 / 2") shouldBe 2.5
        Calculator.execute("20 / 4 / 2") shouldBe 2.5
        Calculator.execute("6 / 6") shouldBe 1.0
    }

    "사칙연산" {
        Calculator.execute("2 + 3 * 4 / 2") shouldBe 10.0
        Calculator.execute("30 + 7 * 3 / 4 * 4 + 100 - 32") shouldBe 179.0
        Calculator.execute("2 - 4 + 6 * 10 * 7 / 2 / 10") shouldBe 14.0
    }

    "입력 값이 null 또는 blank일 때 IllegalArgumentException이 발생해야 한다" {
        shouldThrow<IllegalArgumentException> {
            Calculator.execute("")
            Calculator.execute(" ")
            Calculator.execute("      ")
            Calculator.execute(null)
        }
    }

    "정의되어 있지 않은 Operation 입력 시 IllegalArgumentException이 발생해야 한다" {
        shouldThrow<IllegalArgumentException> {
            Calculator.execute("2 & 4")
            Calculator.execute("1 + 1 ^ 2")
        }
    }
})
