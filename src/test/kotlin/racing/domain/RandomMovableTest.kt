package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest

import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RandomMovableTest {

    companion object {
        @JvmStatic
        fun source(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(0, false),
                Arguments.arguments(1, false),
                Arguments.arguments(2, false),
                Arguments.arguments(3, false),
                Arguments.arguments(4, true),
                Arguments.arguments(5, true),
                Arguments.arguments(6, true),
                Arguments.arguments(7, true),
                Arguments.arguments(8, true),
                Arguments.arguments(9, true)

            )
        }
    }

    @MethodSource("source")
    @ParameterizedTest
    fun `전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다`(randomVal: Int, expect: Boolean) {
        val randomGenerator: RandomGenerator = object : RandomGenerator {
            override fun nextInt(max: Int): Int = randomVal
        }

        val result = RandomMovable(randomGenerator = randomGenerator, max = 9, threshold = 4).isMovable()
        assertThat(result).isEqualTo(expect)
    }
}
