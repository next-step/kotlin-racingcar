package study.calculator

import calculator.Operator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({
    "덧셈" {
        val operator = Operator.PLUS
        val result = operator.invoke(1, 2)
        result shouldBe 3
    }

    "뺄셈" {
        val operator = Operator.MINUS
        val result = operator.invoke(2, 1)
        result shouldBe 1
    }

    "곱셈" {
        val operator = Operator.MULTIPLY
        val result = operator.invoke(2, 3)
        result shouldBe 6
    }

    "나눗셈" {
        val operator = Operator.DIVIDE
        val result = operator.invoke(6, 2)
        result shouldBe 3
    }

    "operator valueOf '+' character" {
        val sign = '+'
        val operator = Operator.valueOf(sign)
        operator shouldBe Operator.PLUS
    }

    "operator valueOf '-' character" {
        val sign = '-'
        val operator = Operator.valueOf(sign)
        operator shouldBe Operator.MINUS
    }

    "operator valueOf '*' character" {
        val sign = '*'
        val operator = Operator.valueOf(sign)
        operator shouldBe Operator.MULTIPLY
    }

    "operator valueOf '/' character" {
        val sign = '/'
        val operator = Operator.valueOf(sign)
        operator shouldBe Operator.DIVIDE
    }
})
