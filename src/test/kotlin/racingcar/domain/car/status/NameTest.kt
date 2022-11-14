package racingcar.domain.car.status

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {
    @DisplayName("이름이 5자 이하인 경우")
    @ParameterizedTest
    @ValueSource(strings = ["pobi", "crong", "honux"])
    fun `이름이 5자 이하인 경우`(name: String) {
        assertThat(Name(name)).isEqualTo(Name(name))
    }

    @DisplayName("이름이 빈 문자열이거나 공백인 경우")
    @ParameterizedTest
    @ValueSource(strings = ["", "pobi ", "po bi", " pobi", "p  bi", "p b i"])
    fun `이름이 빈 문자열이거나 공백인 경우`(name: String) {
        assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("이름에 빈 문자열이거나 공백이 있습니다.")
    }

    @DisplayName("이름이 5자 초과인 경우")
    @ParameterizedTest
    @ValueSource(strings = ["pororo", "tongtongi", "crongcrong", "Hannah", "Christina", "Joannes"])
    fun `이름이 5자 초과인 경우`(name: String) {
        assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("이름은 5글자 이하만 가능합니다.")
    }

    @DisplayName("이름에 알파벳 이외의 문자가 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = ["pobi1", "1pobi", "pobi!", "pobi@", "pobi#", "po#bi", "해나", "진이", "정"])
    fun `이름에 알파벳 이외의 문자가 있는_경우`(name: String) {
        assertThatThrownBy { Name(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("이름은 알파벳만 가능합니다.")
    }
}
