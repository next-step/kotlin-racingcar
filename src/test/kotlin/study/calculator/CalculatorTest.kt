package study.calculator

import calculator.ArithmeticExpression
import calculator.StringCalculator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CalculatorTest : StringSpec({
    "2 + 3 * 4 / 2 와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10이 반환된다" {
        val expression = "2 + 3 * 4 / 2"
        val actual = StringCalculator(ArithmeticExpression(expression)).calculate()
        val expected = 10

        actual shouldBe expected
    }

    "문자열이 숫자 하나일 경우 그값을 반환한다" {
        val expression = "2"
        val actual = StringCalculator(ArithmeticExpression(expression)).calculate()
        val expected = 2

        actual shouldBe expected
    }

    "연산식이 공백인 경우 Exception을 반환한다" {
        shouldThrow<IllegalArgumentException> {
            val expression = ""
            StringCalculator(ArithmeticExpression(expression)).calculate()
        }
    }
})
