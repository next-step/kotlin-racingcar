package stringcalculator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `문자열이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생`(input: String?) {
        assertThatIllegalArgumentException()
            .isThrownBy { StringCalculator.calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["!@#$%^&()", "4@4", "1!2@3#4$5%, 6^7&89(0)"])
    fun `입력 받은 문자열에 사칙연산 기호가 없는 경우 IllegalArgumentException 발생`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { StringCalculator.calculate(input) }
    }
}
