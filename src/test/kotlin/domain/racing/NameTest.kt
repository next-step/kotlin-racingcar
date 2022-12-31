package domain.racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `자동차 이름은 빈값일 수 없다`(name: String) {
        Assertions.assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 빈값일 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456", "1234567"])
    fun `자동차 이름은 5자를 초과할 수 없다`(name: String) {
        Assertions.assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.")
    }
}
