package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnerTest {

    @Test
    fun `우승자를 가린다`() {
        val winner = Winner(
            listOf(RacingResult("pobi", 1), RacingResult("crong", 1), RacingResult("honux", 0))
        )

        assertEquals(listOf(RacingResult("pobi", 1), RacingResult("crong", 1)), winner.evaluate())
    }
}
