package calculator.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OperatorTest {

    @Test
    fun `사칙연산 연산자 문자를 정상적으로 변환한다`() {
        val operatorCodes = listOf("+", "-", "*", "/")
        val result = operatorCodes.map { Operator.of(it) }
        assertThat(result).isEqualTo(listOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLE, Operator.DIVIDE))
    }

    @Test
    fun `유효하지 않은 연산자 문자는 변환 시 예외를 반환한다`() {
        val illegalOperatorCode = "|"
        val expectedMessage = "허용하지 않는 연산자"

        val result = assertThrows<IllegalArgumentException> { Operator.of(illegalOperatorCode) }
        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
