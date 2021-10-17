package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import racingcar.mock.TrueRacingCarForwardCondition

class CarsTest {

    @Test
    fun `Cars는 최소 1대 이상이어야 한다`() {
        // given & when
        val executable = Executable {
            Cars(listOf(), TrueRacingCarForwardCondition())
        }

        // then
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun `Cars move() 기능 테스트`() {
        // given
        val cars = Cars(
            carNames = listOf(
                CarName("pobi"),
                CarName("crong"),
                CarName("honux")
            ),
            condition = TrueRacingCarForwardCondition()
        )

        // when
        val expected = 5
        repeat(5) { cars.move() }

        // then
        cars.forEach { car ->
            assertEquals(expected, car.position)
        }
    }
}
