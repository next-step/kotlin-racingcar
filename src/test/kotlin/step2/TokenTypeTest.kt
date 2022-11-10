package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TokenTypeTest : FunSpec({
    context("getByValue 메서드는") {
        context("연산자 토큰 값을 입력하면") {
            test("연산자 토큰 유형을 반환한다.") {
                val actual = TokenType.getByValue(value = "+")
                actual shouldBe TokenType.OPERATOR
            }
        }

        context("피연산자 토큰 값을 입력하면") {
            test("피연산자 토큰 유형을 반환한다.") {
                val actual = TokenType.getByValue(value = "3")
                actual shouldBe TokenType.OPERAND
            }
        }
    }

    context("isOperator 메서드는") {
        test("연산자 유형이면 true 를 피연산자 유형이면 false 를 반환한다.") {
            TokenType.OPERATOR.isOperator() shouldBe true
            TokenType.OPERAND.isOperator() shouldBe false
        }
    }

    context("isOperand 메서드는") {
        test("피연산자 유형이면 true 를 연산자 유형이면 false 를 반환한다.") {
            TokenType.OPERAND.isOperand() shouldBe true
            TokenType.OPERATOR.isOperand() shouldBe false
        }
    }
})
