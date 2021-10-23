package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.extension.StringExtension.isIntType

class StringExtensionTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "한글", "english", "!", "12#$"])
    fun `입력값이 숫자가 아니다`(input: String) {
        Assertions.assertFalse(input.isIntType())
    }
}
