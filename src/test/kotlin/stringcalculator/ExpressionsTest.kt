package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExpressionsTest : StringSpec({
    "단항 테스트" {
        UnaryExpression("1").evaluate() shouldBe 1
        UnaryExpression("+1").evaluate() shouldBe 1
        UnaryExpression("-1").evaluate() shouldBe -1
    }

    "올바르지 않은 단항 테스트" {
        shouldThrowExactly<NumberFormatException> { UnaryExpression("--1").evaluate() }
        shouldThrowExactly<NumberFormatException> { UnaryExpression("++1").evaluate() }
        shouldThrowExactly<NumberFormatException> { UnaryExpression("-+1").evaluate() }
        shouldThrowExactly<NumberFormatException> { UnaryExpression("+-1").evaluate() }
    }

    "+ 연산 테스트" {
        BinaryExpression(UnaryExpression("1"), Operator.PLUS, UnaryExpression("2")).evaluate() shouldBe 3
    }

    "- 연산 테스트" {
        BinaryExpression(UnaryExpression("1"), Operator.MINUS, UnaryExpression("2")).evaluate() shouldBe -1
    }

    "/ 연산 테스트" {
        BinaryExpression(UnaryExpression("1"), Operator.DIVIDE, UnaryExpression("2")).evaluate() shouldBe 0.5
    }

    "* 연산 테스트" {
        BinaryExpression(UnaryExpression("1"), Operator.MULTIPLY, UnaryExpression("2")).evaluate() shouldBe 2
    }
})
