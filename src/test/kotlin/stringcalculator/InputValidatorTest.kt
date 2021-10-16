package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "1 + 2", "1 + 2 + 3"])
    fun `입력이 정상이면 공백을 기준으로 분리한 문자열의 리스트를 반환한다`(input: String) {
        val splitString = InputValidator().validate(input)

        assertThat(splitString).isEqualTo(input.split(" "))
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력이 비어있으면 IllegalArgumentException 을 일으킨다`(input: String?) {
        assertThrows<IllegalArgumentException> {
            InputValidator().validate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 2", "1 2 3", "1 + 2 +", "+ 1 + 2", "1+2", "1 +2", "1+ 2", " 1 + 2", "1 + 2 "])
    fun `입력이 올바르게 구성되어 있지 않으면 IllegalArgumentException 을 일으킨다`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator().validate(input)
        }
    }
}
