package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InfixExpressionFormatValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1 x 2 q 3", "1 * 2 q 3", "1 x q  + 3"])
    fun `사칙 연산과 숫자로 이루어져 있는 숫자가 아니면 에러`(input: String) {
        // given
        val validator = InfixExpressionFormatValidator()

        // when & then
        Assertions.assertThatThrownBy { validator.validateExpressionFormat(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("수식은 사칙연산과 숫자만 가능합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1/2-3", "1*2+3", "1-2+3"])
    fun `사칙 연산과 숫자로 이루어져 있으면 성공`(input: String) {
        // given
        val validator = InfixExpressionFormatValidator()

        // when
        Assertions.assertThatCode { validator.validateExpressionFormat(input) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `연산자가 피연산자 같을 경우 에러 발생`() {
        // given
        val validator = InfixExpressionFormatValidator()
        val operands = listOf("1", "2", "3")
        val operators = listOf("+", "/", "+")

        // when & then
        Assertions.assertThatThrownBy { validator.validateNumberOfOperands(operands, operators) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산자가 피연산자 보다 많을 수 없습니다.")
    }

    @Test
    fun `연산자가 피연산자 많을 경우 에러 발생`() {
        // given
        val validator = InfixExpressionFormatValidator()
        val operands = listOf("1", "2", "3")
        val operators = listOf("+", "+", "+", "-")

        // when & then
        Assertions.assertThatThrownBy { validator.validateNumberOfOperands(operands, operators) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산자가 피연산자 보다 많을 수 없습니다.")
    }

    @Test
    fun `연산자가 피연산자 적을 경우`() {
        // given
        val validator = InfixExpressionFormatValidator()
        val operands = listOf("1", "2", "3")
        val operators = listOf("+", "-")

        // when & then
        Assertions.assertThatCode { validator.validateNumberOfOperands(operands, operators) }
            .doesNotThrowAnyException()
    }
}
