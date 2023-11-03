package game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CarNameParserTest {

    @ParameterizedTest
    @MethodSource("provideCarNames")
    fun `자동차 이름을 쉼표를 기준으로 분리한다`(input: String, expected: List<String>) {
        val carNames = CarNameParser.parse(input)
        assertThat(carNames).containsExactly(*expected.toTypedArray())
    }

    companion object {
        @JvmStatic
        fun provideCarNames(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("apple,banana", listOf("apple", "banana")),
                Arguments.of("pobi,crong,honux", listOf("pobi", "crong", "honux")),
                Arguments.of("a,b,c,d", listOf("a", "b", "c", "d")),
                Arguments.of("14,15,16,17", listOf("14", "15", "16", "17")),
                Arguments.of("`~1!2@3#4$5%6^7&8*9(0).;:'\\|\"[{}]", listOf("`~1!2@3#4\$5%6^7&8*9(0).;:'\\|\"[{}]"))
            )
        }
    }
}
