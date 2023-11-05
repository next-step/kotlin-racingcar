package study

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racinggame.RacingCarGame

class RacingCarGameTest {

    @Test
    fun `테스트 인자`() {
        assertThrows<IllegalStateException> { RacingCarGame() }
        assertThrows<IllegalStateException> { RacingCarGame().playing() }
    }
    
}
