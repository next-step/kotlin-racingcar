package study.racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun moveForward() {
        // given
        val racingCar = RacingCar("test", 1)

        // when
        racingCar.moveForward()

        // then
        assertEquals(2, racingCar.position)
    }

    @Test
    fun moveBackward() {
        // given
        val racingCar = RacingCar("test", 2)

        // when
        racingCar.moveBackward()

        // then
        assertEquals(1, racingCar.position)
    }

    @Test
    fun moveBackWardWhenPositionIsOne() {
        // given
        val racingCar = RacingCar("test", 1)

        // when
        racingCar.moveBackward()

        // then
        assertEquals(1, racingCar.position)
    }

    @Test
    fun getId() {
        // given
        val racingCar = RacingCar("test", 1)

        // when
        val id = racingCar.id

        // then
        assertEquals("test", id)
    }

    @Test
    fun getPosition() {
        // given
        val racingCar = RacingCar("test", 1)

        // when
        val position = racingCar.position

        // then
        assertEquals(1, position)
    }

    @Test
    fun setPosition() {
        // given
        val racingCar = RacingCar("test", 1)

        // when
        racingCar.position = 2

        // then
        assertEquals(2, racingCar.position)
    }
}
