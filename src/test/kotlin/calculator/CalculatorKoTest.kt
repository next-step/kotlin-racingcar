package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorKoTest : StringSpec({
    val arithmeticOperation = ArithmeticOperation()
    val calculatorValidator = CalculatorValidator()
    val sut = Calculator(arithmeticOperation, calculatorValidator)

    "문자열 계산기의 덧셈이 성공적으로 동작한다." {
        val operand1 = "5"
        val operand2 = "2"

        val result = sut.calculateExpression("$operand1 + $operand2")

        result shouldBe 7
    }

    "문자열 계산기의 뺄셈이 성공적으로 동작한다." {
        val expression = "5 - 3"

        val result = sut.calculateExpression(expression)

        result shouldBe 2
    }

    "문자열 계산기의 곱셈이 성공적으로 동작한다." {
        val expression = "- 5 * 4"

        val result = sut.calculateExpression(expression)

        result shouldBe -20
    }

    "문자열 계산기의 나눗셈이 성공적으로 동작한다." {
        val expression = "10 / 2"

        val result = sut.calculateExpression(expression)

        result shouldBe 5
    }

    "문자열 계산기의 사칙연산이 정상적으로 동작한다." {
        val expression = "2 + 3 * 4 / 2"

        val result = sut.calculateExpression(expression)

        result shouldBe 10
    }

    "문자열 계산기의 나눗셈에서 0으로 나누는 경우 ArithmeticException throw." {
        val expression = "10 / 0"

        shouldThrow<ArithmeticException> {
            sut.calculateExpression(expression)
        }
    }

    "입력값이 빈 공백 문자일 경우 IllegalArgumentException throw" {
        val expression = ""

        shouldThrow<IllegalArgumentException> {
            sut.calculateExpression(expression)
        }
    }

    "사칙연산 기호가 아닌 경우 IllegalArgumentException throw" {
        val expression = "1 = 3 + 1 + 4"

        shouldThrow<IllegalArgumentException> {
            sut.calculateExpression(expression)
        }
    }
})
