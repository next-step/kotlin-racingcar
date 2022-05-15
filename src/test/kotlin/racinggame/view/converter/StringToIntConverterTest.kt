package racinggame.view.converter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringToIntConverterTest {
    @ParameterizedTest
    @CsvSource(value = ["1:1", "2:2", "10:10", "512:512", "17547:17547"], delimiter = ':')
    fun `StringToIntConverter는 string input을 Int로 변환한다`(input: String, expected: Int) {

        assertThat(StringToIntConverter.convert(input)).isEqualTo(expected)
    }

    @Test
    fun `StringToIntConverter에 Int로 변환시킬 수 없는 입력값이 들어오면 NumberFormatException이 발생한다`() {
        assertThrows<NumberFormatException> {
            StringToIntConverter.convert("ㅋㅋㅋ")
        }
    }
}
