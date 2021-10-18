package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class NamesTest {

    @Test
    fun `텍스트를 입력받아 이름 목록을 생성한다`() {
        val givenText = "pobi,crong,honux"

        val actual = Names.generateNames(givenText)

        assertThat(actual.names).containsExactly(
            Name("pobi"),
            Name("crong"),
            Name("honux")
        )
    }

    @NullAndEmptySource
    @ParameterizedTest
    fun `공백인 텍스트를 입력하면 예외를 던진다`(givenText: String?) {
        assertThatCode { Name(givenText) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
