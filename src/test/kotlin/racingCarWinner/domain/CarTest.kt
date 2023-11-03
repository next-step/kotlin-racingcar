package racingCarWinner.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingCarWinner.domain.strategy.AlwaysMoveStrategy
import racingCarWinner.domain.strategy.AlwaysNotMoveStrategy

class CarTest {

    @Test
    fun `movable한 차는 1칸 앞으로 전진한다`() {
        // given
        val car = Car.of(
            name = "pobi",
            strategy = AlwaysMoveStrategy
        )

        // when
        car.move()

        // then
        assertEquals(1, car.location)
    }

    @Test
    fun `movable하지 않은 차는 그대로 멈춰있다`() {
        // given
        val car = Car.of(
            name = "pobi",
            strategy = AlwaysNotMoveStrategy
        )

        // when
        car.move()

        // then
        assertEquals(0, car.location)
    }
}