package stringArithmeticCalculator

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `입력값이 빈 공백 문자일 경우`(input : String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy{ Calculator(input) }
            .withMessage("공백 문자는 올 수 없습니다.")
    }
}