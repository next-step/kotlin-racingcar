package calculator.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("사칙 연산 계산기 테스트")
class CalculatorTest {

    @CsvSource("1, +, 2, 3", "1, -, 2, -1", "4, *, 5, 20", "8, /, 2, 4")
    @ParameterizedTest
    fun `두 수를 사칙 연산한 결과를 반환한다`(number1: Int, operator: Char, number2: Int, expected: Int) {
        assertEquals(expected, Calculator(number1, operator, number2).calculate())
    }

    @Test
    fun `나누고자 하는 수가 0인 경우 예외를 던진다`() {
        assertThatThrownBy { Calculator(10, '/', 0).calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로 나눌 수 없습니다.")
    }

    @Test
    fun `올바르지 않은 연산자 입력 시 예외를 던진다`() {
        assertThatThrownBy { Calculator(1, '?', 2).calculate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("올바르지 않은 연산자 입니다.")
    }
}
