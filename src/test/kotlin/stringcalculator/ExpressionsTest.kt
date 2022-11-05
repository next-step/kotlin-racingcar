package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExpressionsTest : StringSpec({
    "단항 테스트" {
        UnaryExpression("1").evaluate() shouldBe 1
        UnaryExpression("1").evaluate() shouldBe 1
        UnaryExpression("-1").evaluate() shouldBe -1
    }

    "올바르지 않은 단항 테스트" {
        shouldThrowExactly<NumberFormatException> { UnaryExpression("--1").evaluate() }
        shouldThrowExactly<NumberFormatException> { UnaryExpression("++1").evaluate() }
        shouldThrowExactly<NumberFormatException> { UnaryExpression("-+1").evaluate() }
        shouldThrowExactly<NumberFormatException> { UnaryExpression("+-1").evaluate() }
    }

    "+ 연산 테스트" {
        PlusBinaryExpression(UnaryExpression("1"), UnaryExpression("2")).evaluate() shouldBe 3
    }

    "- 연산 테스트" {
        MinusBinaryExpression(UnaryExpression("1"), UnaryExpression("2")).evaluate() shouldBe -1
    }

    "/ 연산 테스트" {
        DivideBinaryExpression(UnaryExpression("1"), UnaryExpression("2")).evaluate() shouldBe 0.5
    }

    "* 연산 테스트" {
        MultiplyBinaryExpression(UnaryExpression("1"), UnaryExpression("2")).evaluate() shouldBe 2
    }
})
