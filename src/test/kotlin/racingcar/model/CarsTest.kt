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

    @Test
    fun `position이 가장 앞서있는 자동차들이 우승자가 된다`() {
        // given
        val carNames = listOf(
            CarName("pobi"),
            CarName("crong"),
            CarName("honux")
        )
        val cars = Cars(
            carNames = carNames,
            condition = TrueRacingCarForwardCondition()
        )

        // when
        val expected = carNames.toList()
        repeat(5) { cars.move() }

        // then
        val actual = cars.getWinners().map { it.carName }
        assertEquals(expected, actual)
    }
}
