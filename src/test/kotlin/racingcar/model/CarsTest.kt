package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import racingcar.mock.AlwaysForwardRacingCarForwardCondition

class CarsTest {

    @Test
    fun `Cars는 최소 1대 이상이어야 한다`() {
        // given & when
        val executable = Executable {
            Cars(listOf())
        }

        // then
        assertThrows(IllegalArgumentException::class.java, executable)
    }

    @Test
    fun `Cars move() 기능 테스트`() {
        // given
        val cars = createMockCars()

        // when
        val expected = 5
        repeat(5) { cars.move() }

        // then
        cars.snapshot(0)
            .forEach { car ->
                assertEquals(expected, car.position)
            }
    }

    @Test
    fun `position이 가장 앞서있는 자동차들이 우승자가 된다`() {
        // given
        val condition = AlwaysForwardRacingCarForwardCondition()
        val cars = createMockCars(condition)

        // when
        val expected = listOf("pobi", "crong", "honux")
            .map { name ->
                Car(
                    carName = CarName(name),
                    position = 5,
                    condition = condition
                )
            }
        repeat(5) { cars.move() }

        // then
        val actual = cars.filterWinners()
        assertEquals(expected, actual)
    }

    private fun createMockCars(
        condition: RacingCarForwardCondition = AlwaysForwardRacingCarForwardCondition()
    ): Cars = listOf("pobi", "crong", "honux")
        .map { name ->
            Car(
                carName = CarName(name),
                condition = condition
            )
        }
        .let(::Cars)
}
