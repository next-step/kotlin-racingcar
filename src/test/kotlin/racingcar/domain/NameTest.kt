package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NameTest {

    @DisplayName("자동차의 이름은 공백일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  "])
    fun `빈 이름`(name: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Name(name) }
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = ["123456", "abcdefg", "Anonymous"])
    fun `긴 이름`(name: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Name(name) }
            .withMessage("자동차 이름은 5자를 초과할 수 없다.")
    }
}
