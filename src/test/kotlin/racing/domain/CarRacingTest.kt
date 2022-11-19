package racing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class CarRacingTest {

    @Test
    fun `주어진 자동차 이름의 개수만큼 자동차를 생성한다`() {
        // given
        val namesOfCars = listOf("car1", "car2", "car3")

        // when
        val carRacing = CarRacing(
            namesOfCars = namesOfCars,
            moveStrategy = moveStrategy,
        )

        // then
        assertEquals(namesOfCars.size, carRacing.positions.size)
    }

    @Test
    fun `move 함수를 호출하면 내부의 자동차들이 이동한다`() {
        // given
        val carRacing = CarRacing(
            namesOfCars = listOf("car1", "car2", "car3"),
            moveStrategy = moveStrategy,
        )

        // when
        carRacing.move()

        // then
        assertTrue(carRacing.positions.all { it == MOVE_SIZE })
    }

    companion object {
        const val MOVE_SIZE = 1

        val moveStrategy = MoveStrategy { MOVE_SIZE }
    }
}
