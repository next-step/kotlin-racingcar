package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationCheckerTest {
    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "2", "3", "4"])
    fun `isUnsignedInt() 정상값 입력시 True가 반환 된다`(s: String) {
        assertThat(ValidationChecker.isUnsignedInt(s)).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["s", "s2", "3s", "4s4", "-1", "+1"])
    fun `isUnsignedInt() 잘못된 값 입력시 False가 반환 된다`(s: String) {
        assertThat(ValidationChecker.isUnsignedInt(s)).isFalse
    }
}
