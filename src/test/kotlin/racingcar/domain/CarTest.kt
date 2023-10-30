package racingcar.domain

import io.mockk.every
import io.mockk.mockkObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `RandomMoveStrategy의 isMovable이 true일 때 차는 1칸 앞으로 전진한다`() {
        // given
        mockkObject(RandomMoveStrategy)
        every { RandomMoveStrategy.isMovable() } returns true

        // when
        val car = Car.ofRandom()
        car.move()

        // then
        assertEquals(1, car.location)
    }

    @Test
    fun `RandomMoveStrategy의 isMovable이 false일 때 차는 그대로 멈춰있다`() {
        // given
        mockkObject(RandomMoveStrategy)
        every { RandomMoveStrategy.isMovable() } returns false

        // when
        val car = Car.ofRandom()
        car.move()

        // then
        assertEquals(0, car.location)
    }
}