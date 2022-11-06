package study

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {
    private val calculator = StringCalculator(separator = " ")

    @Test
    fun `더하기 수식을 입력하면 더한 값이 반환된다`() {
        assert(calculator.calculate("12 + 4") == 16)
    }

    @Test
    fun `빼기 수식을 입력하면 뺀 값이 반환된다`() {
        assert(calculator.calculate("12 - 14") == -2)
    }

    @Test
    fun `곱하기 수식을 입력하면 곱한 값이 반환된다`() {
        assert(calculator.calculate("11 * 11") == 121)
    }

    @Test
    fun `나누기 수식을 입력하면 나눈 값이 반환된다`() {
        assert(calculator.calculate("12 / 6") == 2)
    }

    @Test
    fun `0으로 나누는 수식을 입력하면 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate("12 / 0")
        }
        assert(exception.message == "0으로 나눌 수 없습니다.")
    }

    @Test
    fun `복합 연산 수식을 입력하면 순서대로 계산된 값이 반환된다`() {
        assert(calculator.calculate("12 + 6 / 2 * 10 - 4") == 86)
    }

    @Test
    fun `공백을 입력하면 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate("")
        }
        assert(exception.message == "input이 null이거나 공백입니다.")
    }

    @Test
    fun `Whitespace를 입력하면 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate("     ")
        }
        assert(exception.message == "input이 null이거나 공백입니다.")
    }

    @Test
    fun `null을 입력하면 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate(null)
        }
        assert(exception.message == "input이 null이거나 공백입니다.")
    }

    @Test
    fun `올바르지 않은 수식을 입력하면 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate("123 * + 44")
        }
        assert(exception.message == "숫자가 아닌 값이 숫자자리에 입력되었습니다.")
    }

    @Test
    fun `숫자가 하나인 수식을 입력하면 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate("123 *")
        }
        assert(exception.message == "하나 이상의 숫자가 입력되어야합니다.")
    }

    @Test
    fun `사칙연산이 아닌 수식을 입력하면 에러가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculate("123 & 44")
        }
        assert(exception.message == "사칙연산 기호가 아닙니다.")
    }
}