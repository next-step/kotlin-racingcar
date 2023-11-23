package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.dto.RacingResult

class RacingGameTest {

    @Test
    fun `레이싱 한다`() {
        val cars = listOf(
            Car("pobi", { 4 }, 1),
            Car("crong", { 3 }, 0),
            Car("honux", { 10 }, 1),
        )

        val expected = listOf(
            RacingResult("pobi", 2),
            RacingResult("crong", 0),
            RacingResult("honux", 2),
        )

        assertEquals(expected, RacingGame().race(cars))
    }
}
