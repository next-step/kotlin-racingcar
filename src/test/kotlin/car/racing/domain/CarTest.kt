package car.racing.domain

import car.racing.exception.OutOfRangeException
import car.racing.helper.AboveStandardGenerator
import car.racing.helper.BelowStandardGenerator
import car.racing.usecase.NumberMovingStrategy
import car.racing.usecase.NumberRandomGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `이름 5글자 미만일 때 생성 성공`() {
        val car = Car("csy4", 5, NumberMovingStrategy(NumberRandomGenerator()))
    }

    @Test
    fun `이름 5글자 이상일 때 생성 실패`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("csy12", 5, NumberMovingStrategy(NumberRandomGenerator()))
        }

        assertEquals("이름의 길이는 5 보다 작아야합니다.", exception.message)
    }

    @Test
    fun `Move 의 결과가 잘 반영됐는지 테스트`() {
        val car = Car("csy", 5, NumberMovingStrategy(NumberRandomGenerator()))

        repeat(5) { turn ->
            val isMove = car.move()
            val moveDistance = car.getMovesUntilTurn(turn)

            assertEquals(isMove, moveDistance[turn])
        }
    }

    @Test
    fun `조건이 맞으면 true`() {
        val car = Car("csy", 5, NumberMovingStrategy(AboveStandardGenerator()))
        val result = car.move()

        assertTrue(result)
    }

    @Test
    fun `조건이 충족 안되면 false`() {
        val car = Car("csy", 5, NumberMovingStrategy(BelowStandardGenerator()))
        val result = car.move()

        assertFalse(result)
    }

    @Test
    fun `TurnCount 보다 많이 Move 했을경우 OutOfRangeException`() {
        val size = 1
        val exception = assertThrows<OutOfRangeException> {
            val car = Car("csy", size, NumberMovingStrategy(NumberRandomGenerator()))
            repeat(size + 1) {
                car.move()
            }
        }

        val expected = "move 메소드는 turnCount 보다 많이 실행될 수 없습니다. turnCount: $size, move method call count: ${size + 1}"
        assertEquals(expected, exception.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `getMoveDistanceUntilTurn(N) 일때 size ( N + 1 )`(size: Int) {
        val car = Car("csy", size, NumberMovingStrategy(NumberRandomGenerator()))
        val moveDistanceSize = car.getMovesUntilTurn(size - 1).size

        assertEquals(size, moveDistanceSize)
    }
}
