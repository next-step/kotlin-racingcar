package calculator

import calculator.dto.ExtractDTO
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["20 + 1 * 4 / 2"])
    fun `문자열 계산을 위한 문자열 내 숫자 및 연산 기호 추출`(input: String) {

        val expected = ExtractDTO(
            numbers = mutableListOf(20.0, 1.0, 4.0, 2.0),
            operators = mutableListOf('+', '*', '/')
        )

        val result = StringCalculator().extractNumbersAndOperators(input)

        assertThat(result.numbers).isEqualTo(expected.numbers)
        assertThat(result.operators).isEqualTo(expected.operators)
    }
}
