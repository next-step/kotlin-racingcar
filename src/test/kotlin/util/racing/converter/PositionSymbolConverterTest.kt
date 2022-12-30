package util.racing.converter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositionSymbolConverterTest {

    companion object {
        private const val SYMBOL = "-"
    }

    @ValueSource(ints = [0, 1, 2, 3, 4, 5])
    @ParameterizedTest
    fun `position에 맞게 symbol이 출력된다`(position: Int) {
        assertThat(PositionSymbolConverter.converter(position)).isEqualTo(SYMBOL.repeat(position))
    }
}
