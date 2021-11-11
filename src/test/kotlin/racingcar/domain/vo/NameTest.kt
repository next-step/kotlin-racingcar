package racingcar.domain.vo

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class NameTest {

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" "])
    fun `잘못된 이름을 생성하면 예외를 발생한다`(input: String) {
        assertThatThrownBy { Name(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효하지 않은 자동차 이름입니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "abcdefg"])
    fun `이름이 5자를 초과하면 예외를 발생한다`(input: String) {
        assertThatThrownBy { Name(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.")
    }
}
