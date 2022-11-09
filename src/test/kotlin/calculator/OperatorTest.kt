package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class OperatorTest : StringSpec({
    "덧셈 기호 (+) 의 연산자" {
        val plusSymbol = "+"
        val plusOperator = Operator.of(plusSymbol)

        plusOperator shouldBe Operator.PLUS
    }

    "뺄셈 기호 (-) 의 연산자" {
        val minusSymbol = "-"
        val minusOperator = Operator.of(minusSymbol)

        minusOperator shouldBe Operator.MINUS
    }

    "곱셈 기호 (*) 의 연산자" {
        val multiSymbol = "*"
        val multiOperator = Operator.of(multiSymbol)

        multiOperator shouldBe Operator.MULTI
    }

    "나누셈 기호 (/) 의 연산자" {
        val divSymbol = "/"
        val divOperator = Operator.of(divSymbol)

        divOperator shouldBe Operator.DIV
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
