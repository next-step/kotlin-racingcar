package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnerTest {

    @Test
    fun `우승자를 가린다`() {
        val winner = Winner(
            RacingSituations(
                listOf(
                    RacingSituation(Car("pobi", 1)),
                    RacingSituation(Car("crong", 1)),
                    RacingSituation(Car("honux", 0))
                )
            )
        )

        assertEquals(
            RacingSituations(listOf(RacingSituation(Car("pobi", 1)), RacingSituation(Car("crong", 1)))),
            winner.evaluate()
        )
    }
}
