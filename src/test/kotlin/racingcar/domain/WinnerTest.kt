package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnerTest {

    @Test
    fun `우승자를 가린다`() {
        val winner = Winner(
            listOf(
                RacingSituation("pobi", 1),
                RacingSituation("crong", 1),
                RacingSituation("honux", 0)
            )
        )

        assertEquals(listOf(RacingSituation("pobi", 1), RacingSituation("crong", 1)), winner.evaluate())
    }
}
