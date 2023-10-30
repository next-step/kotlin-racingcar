package racingCar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy

class CarsTest {

    private lateinit var cars: Cars
    private val moveStrategy: MoveStrategy = RandomStrategy()

    @BeforeEach
    fun setUp() {
        cars = Cars(moveStrategy)
    }

    @Test
    fun getCarsTest() {
        val carList = cars.getCars(CARS)
        assertEquals(3, carList.size)
    }

    @Test
    fun `자동차 Name의 길이는 5 초과가 되어선 안된다`() {
        assertThrows<IllegalArgumentException> {
            cars.getCars(LENGTH_OVER_CARS)
        }
    }

    @Test
    fun getWinnerTest() {
        val car1 = Car("car1", 3, moveStrategy)
        val car2 = Car("car2", 2, moveStrategy)
        val car3 = Car("car3", 3, moveStrategy)

        val carList = listOf(car1, car2, car3)
        val winners = cars.getWinners(carList)

        assertEquals("car1, car3", winners)
    }

    companion object {
        private const val CARS = "pobi,crong,honux"
        private const val LENGTH_OVER_CARS = "pobiaaa,crongbbb,honuxccc"
    }
}
