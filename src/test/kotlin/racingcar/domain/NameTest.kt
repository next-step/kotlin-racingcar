package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "crong", "honux"])
    fun `이름을 생성할 수 있다`(givenName: String) {
        val name = Name(givenName)

        assertThat(name).isNotNull
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 값을 이름으로 생성하면 예외를 던진다`(givenName: String?) {
        Assertions.assertThatCode { Name(givenName) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "aaabbbccc", "aaabbbcccddd"])
    fun `이름 길이가 5자를 초과하면 예외를 던진다`(givenName: String?) {
        Assertions.assertThatCode { Name(givenName) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
