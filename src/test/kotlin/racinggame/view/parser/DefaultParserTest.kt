package racinggame.view.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DefaultParserTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100, 2, 4, 50, 214, 46, 123])
    fun `DefaultParser는 input을 그대로 반환해 준다`(input: Int) {
        val parser = DefaultParser<Int>()

        assertThat(parser.parse(input)).isEqualTo(input)
    }
}