package racinggame.view.converter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NameConverterTest {
    @Test
    fun `NameConverter는 ,를 기준으로 문자열 입력값을 나눠 리스트로 반환한다`() {
        val input = "fender,fodera,sadowsky,musicman"
        val expected = listOf("fender", "fodera", "sadowsky", "musicman")

        val converter = NameConverter()
        assertThat(converter.convert(input)).isEqualTo(expected)
    }
}