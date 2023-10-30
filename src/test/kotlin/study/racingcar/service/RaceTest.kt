package study.racingcar.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import study.racingcar.inteface.MoveStrategy

class RaceTest {

    private val alwaysMove = MoveStrategy { true }

    @Test
    @DisplayName("주어진 횟수만큼 자동차들이 움직여야 한다")
    fun `run should update car positions correctly`() {
        val carNames = listOf("Car1", "Car2", "Car3")
        val race = Race.createWithCarNames(carNames, 5, alwaysMove)
        race.run()
        val expectedPositions = listOf(5, 5, 5)
        val actualPositions = race.cars.map { it.position }
        assertEquals(expectedPositions, actualPositions)
    }

    @Test
    @DisplayName("자동차 대수가 0 이하일 때 예외를 던져야 한다.")
    fun `should throw Exception when car count is zero or negative`() {
        assertThrows<IllegalArgumentException> {
            Race.createWithCarNames(emptyList(), 5, alwaysMove)
        }
    }

    @Test
    @DisplayName("시도할 횟수가 0 이하일 때 예외를 던져야 한다.")
    fun `should throw exception when move count is zero or negative`() {
        val carNames = listOf("car1", "car2", "car3")
        assertThrows<IllegalArgumentException> {
            Race.createWithCarNames(carNames, 0, alwaysMove)
        }

        assertThrows<IllegalArgumentException> {
            Race.createWithCarNames(carNames, -1, alwaysMove)
        }
    }
}
