package study.step3.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import study.step3.inteface.MoveStrategy

class RaceTest {

    private val alwaysMove = MoveStrategy { true }

    @Test
    @DisplayName("주어진 횟수만큼 자동차들이 움직여야 한다")
    fun `run should update car positions correctly`() {
        val race = Race(3, 5, alwaysMove)
        race.run()
        val expectedPositions = listOf(5, 5, 5)
        val actualPositions = race.getCars().map { it.getPosition() }
        assertEquals(expectedPositions, actualPositions)
    }
}
