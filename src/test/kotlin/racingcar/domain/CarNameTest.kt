package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = ["가나다라마바사", ""])
    fun `자동차 이름 길이 및 빈값 체크`(inputValue: String) {
        assertThrows<IllegalArgumentException> {
            CarName(inputValue)
        }
    }

    @Test
    fun `green case`() {
        val actual = CarName("가나다")
        assertThat(actual.name).isEqualTo("가나다")
    }
}
