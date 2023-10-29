package racingcar.domain

import io.mockk.every
import io.mockk.mockkObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {

    @ParameterizedTest
    @CsvSource(
        "1, -",
        "2, --",
        "3, ---",
    )
    fun `RandomMoveStrategy의 isMovable이 true일 때 차는 1칸 앞으로 전진한다`(input: String, expected: String) {
        // given
        mockkObject(RandomMoveStrategy)
        every { RandomMoveStrategy.isMovable() } returns true

        // when
        val car = Car.ofRandom()
        repeat(input.toInt()) {
            car.move()
        }

        // then
        assertEquals(expected, car.state)
    }

    @ParameterizedTest
    @CsvSource(
        "1",
        "2",
        "3",
    )
    fun `RandomMoveStrategy의 isMovable이 false일 때 차는 그대로 멈춰있다`(input: String) {
        // given
        mockkObject(RandomMoveStrategy)
        every { RandomMoveStrategy.isMovable() } returns false

        // when
        val car = Car.ofRandom()
        repeat(input.toInt()) {
            car.move()
        }

        // then
        assertEquals("", car.state)
    }
}