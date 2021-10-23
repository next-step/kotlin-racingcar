package racing.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

@Suppress("NonAsciiCharacters")
class RandomEngineTest {

    @Test
    fun `RandomEngine 동작 테스트`() {
        assertDoesNotThrow {
            RandomEngine.canMove()
        }
    }
}
