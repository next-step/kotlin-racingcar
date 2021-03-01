package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @Test
    fun `plus`() {
        assertThat(Operator.PLUS.operator).isEqualTo("+")
    }

    @Test
    fun `minus`() {
        assertThat(Operator.MINUS.operator).isEqualTo("-")
    }

    @Test
    fun `multiply`() {
        assertThat(Operator.MULTIPLY.operator).isEqualTo("*")
    }

    @Test
    fun `division`() {
        assertThat(Operator.DIVISION.operator).isEqualTo("/")
    }

    @ParameterizedTest
    @CsvSource("+, PLUS", "-, MINUS", "*, MULTIPLY", "/, DIVISION")
    fun `연산자를 입력받아서 해당하는 Operator를 리턴한다`(input: String, operator: Operator) {
        assertThat(Operator.operatorOf(input)).isEqualTo(operator)
    }

    @Test
    fun `올바르지 않은 연산자를 입력한 경우 예외처리를 한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Operator.operatorOf("&")
        }.withMessageMatching("잘못된 연산자입니다.")
    }

    @ParameterizedTest
    @CsvSource("0, 10, 10, PLUS", "10, 5, 5, MINUS", "2, 3, 6, MULTIPLY", "10, 2, 5, DIVISION")
    fun `연산자에 해당하는 기능을 실행하여 연산 결과를 리턴한다`(leftOperand: Int, rightOperand: Int, expectedResult: Int, operator: Operator) {
        val result = operator.operate(leftOperand, rightOperand)

        assertThat(result).isEqualTo(expectedResult)
    }
}
