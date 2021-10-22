package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["name-of-six", "name-of-seven", "very-very-long-name"])
    fun `5글자를 초과하는 이름은 사용할 수 없다`(value: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Name(value) }
    }
}
