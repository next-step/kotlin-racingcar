package step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class TokenTest : FunSpec({
    context("isOperator 메서드는") {
        test("토큰이 연산자 유형인지 알 수 있다.") {
            // given
            val operatorToken = Token.from(value = "+")
            val operandToken = Token.from(value = "3")
            // when & then
            operatorToken.isOperator() shouldBe true
            operandToken.isOperator() shouldBe false
        }
    }

    context("isOperand 메서드는") {
        test("토큰이 피연산자 유형인지 알 수 있다.") {
            // given
            val operandToken = Token.from(value = "3")
            val operatorToken = Token.from(value = "+")
            // when & then
            operandToken.isOperand() shouldBe true
            operatorToken.isOperand() shouldBe false
        }
    }

    context("getOperatorSign 메서드는") {
        context("토큰이 연산자 유형이면") {
            test("기호에 해당하는 OperatorSign 을 구할 수 있다.") {
                // given
                val operatorToken = Token.from(value = "/")
                // when & then
                operatorToken.getOperatorSign() shouldBe OperatorSign.DIVIDE
            }
        }

        context("토큰이 피연산자 유형이면") {
            test("IllegalStateException 가 발생한다.") {
                // given
                val operandToken = Token.from(value = "3")
                // when
                val exception = assertThrows<IllegalStateException> {
                    operandToken.getOperatorSign()
                }
                // then
                exception.message shouldBe "연산자 유형인 경우에만 연산 기호를 구할 수 있습니다."
            }
        }
    }

    context("getOperandNumber 메서드는") {
        context("토큰이 피연산자 유형이면") {
            test("피연산자에 해당하는 숫자를 구할 수 있다.") {
                // given
                val operandToken = Token.from(value = "3")
                // when & then
                operandToken.getOperand() shouldBe 3
            }
        }

        context("토큰이 연산자 유형이면") {
            test("IllegalStateException 가 발생한다.") {
                // given
                val operatorToken = Token.from(value = "/")
                // when
                val exception = assertThrows<IllegalStateException> {
                    operatorToken.getOperand()
                }
                // then
                exception.message shouldBe "피연산자 유형인 경우에만 피연산자 숫자를 구할 수 있습니다."
            }
        }
    }
})
