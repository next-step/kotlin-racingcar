package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CarNameTest {

    @Test
    fun `자동차 이름을 조회한다`() {
        val input = "황금마티즈"
        val carName = CarName(input)
        val result = carName.value
        assertThat(result).isEqualTo(input)
    }

    @ParameterizedTest
    @MethodSource("provideCarNamesWithWhitespace")
    fun `자동차 이름은 좌우공백이 제거된다`(input: String, expected: String) {
        val carName = CarName(input)
        val result = carName.value
        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideCarNamesWithWhitespace(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("황금마티즈  ", "황금마티즈"),
                Arguments.of(" 황금마티즈", "황금마티즈"),
                Arguments.of(" 황금마티즈  ", "황금마티즈")
            )
        }
    }
}
