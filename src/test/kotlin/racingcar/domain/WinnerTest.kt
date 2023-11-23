package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.dto.RacingResult

class WinnerTest {

    @Test
    fun `우승자를 가린다`() {
        val winner = Winner(
            RacingSituation(
                listOf(
                    RacingResult("pobi", 1),
                    RacingResult("crong", 1),
                    RacingResult("honux", 0)
                )
            )
        )

        assertEquals(
            RacingSituation(listOf(RacingResult("pobi", 1), RacingResult("crong", 1))),
            winner.evaluate()
        )
    }
}
