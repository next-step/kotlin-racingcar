package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "덧셈" {
        val res = Calculator.execute("1 + 2 + 3")
        res shouldBe 6
    }

    "뺄셈" {
        val res = Calculator.execute("3 - 2 - 1")
        res shouldBe 0
    }

    "나눗셈" {
        val res = Calculator.execute("4 / 2 / 2")
        res shouldBe 1
    }

    "곱셈" {
        val res = Calculator.execute("1 * 2 * 4")
        res shouldBe 8
    }

    "복합식" {
        val res = Calculator.execute("1 + 2 * 4 - 3 / 3")
        res shouldBe 3
    }
})
