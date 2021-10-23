package racing.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.PositionException

@Suppress("NonAsciiCharacters")
class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 10])
    fun `0 또는 양수로 Position 생성`(input: Int) {
        assertDoesNotThrow {
            Position(input)
        }
    }

    @Test
    fun `Position은 음수가 될 수 없다`() {
        assertThatThrownBy {
            Position(-1)
        }.isInstanceOf(PositionException::class.java)
    }
}
