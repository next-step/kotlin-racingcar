package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NameTest {
    @Test
    internal fun `자동차 이름을 생성한다`() {
        val nameString = "crong"
        val name = Name(nameString)
        Assertions.assertThat(name.value).isEqualTo(nameString)
    }

    @Test
    internal fun `자동차 이름은 5자를 초과할 수 없다`() {
        val nameString = "crongg"
        assertThrows<IllegalArgumentException> { Name(nameString) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "  "])
    internal fun `자동차 이름은 공백이나 빈 문자열이 올 수 없다`(nameString: String) {
        assertThrows<IllegalArgumentException> { Name(nameString) }
    }
}
