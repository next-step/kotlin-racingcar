package study.step3.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import study.step3.inteface.MoveStrategy

class RaceTest {

    private val alwaysMove = MoveStrategy { true }

    @Test
    @DisplayName("주어진 횟수만큼 자동차들이 움직여야 한다")
    fun `run should update car positions correctly`() {
        val race = Race(3, 5, alwaysMove)
        race.run()
        val expectedPositions = listOf(5, 5, 5)
        val actualPositions = race.getCars().map { it.position }
        assertEquals(expectedPositions, actualPositions)
    }

    @Test
    @DisplayName("자동차 대수가 0 이하일 때 예외를 던져야 한다.")
    fun `should throw Exception when car count is zero or negative`() {
        assertThrows<IllegalArgumentException> {
            Race(0, 5, alwaysMove)
        }
        assertThrows<IllegalArgumentException> {
            Race(-1, 5, alwaysMove)
        }
    }

    @Test
    @DisplayName("시도할 횟수가 0 이하일 때 예외를 던져야 한다.")
    fun `should throw exception when move count is zero or negative`() {
        assertThrows<IllegalArgumentException> {
            Race(3, 0, alwaysMove)
        }

        assertThrows<IllegalArgumentException> {
            Race(3, -1, alwaysMove)
        }
    }
}
