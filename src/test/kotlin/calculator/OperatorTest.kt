package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

internal class OperatorTest : StringSpec({
    "올바른 사칙연산 기호" {
        val symbols = Operator.values().map { it.symbol }
        val expectSymbols = listOf("+", "-", "*", "/")

        symbols shouldHaveSize 4
        symbols shouldContainAll expectSymbols
    }

    "사칙연산 기호가 아닌 경우 예외 발생" {
        val wrongSymbol = "@"

        shouldThrow<IllegalArgumentException> {
            Operator.of(wrongSymbol)
        }
    }

    "덧셈" {
        val a = 20.0
        val b = 10.0
        Operator.PLUS(a, b) shouldBe 30.0
    }

    "뺄셈" {
        val a = 20.0
        val b = 10.0
        Operator.MINUS(a, b) shouldBe 10.0
    }

    "나눗셈" {
        val a = 20.0
        val b = 10.0
        Operator.DIV(a, b) shouldBe 2.0
    }

    "곱셈" {
        val a = 20.0
        val b = 10.0
        Operator.MULTI(a, b) shouldBe 200
    }
})
