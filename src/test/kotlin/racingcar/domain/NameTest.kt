package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NameTest {
    @Test
    @DisplayName("이름을 생성한다")
    fun create() {
        // given
        val name = "test"

        // when
        val actual = Name("test")

        // then
        assertThat(actual.getName()).isEqualTo(name)
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다")
    fun validateNameLength() {
        // given
        val name = "testtest"

        // when & then
        assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 5자를 초과할 수 없다.")
    }
}
