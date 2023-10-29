package racingCar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingCar.domain.strategy.MoveStrategy

class CarsTest {
    private val testMoveStrategy = MoveStrategy { true }

    companion object {
        private const val CAR_SIZE = 1
        private const val TRY_COUNT = 5
        private const val CARS = "pobi,crong,honux"
        private const val LENGTH_OVER_CARS = "pobiaaa,crongbbb,honuxccc"
    }

    @Test
    fun moveCarTest() {
        val carList: List<Car> = List(CAR_SIZE) { Car("testCar") }
        val cars = Cars(testMoveStrategy)
        cars.moveCar(carList, TRY_COUNT)

        val car = carList[0]
        assertEquals(car.moveCount, 5)
    }

    @Test
    fun getCarsTest() {
        val cars = Cars()
        val carList = cars.getCars(CARS)

        assertEquals(3, carList.size)
    }

    @Test
    fun `자동차 Name의 길이는 5 초과가 되어선 안된다`() {
        val cars = Cars()
        assertThrows<IllegalArgumentException> {
            cars.getCars(LENGTH_OVER_CARS)
        }
    }

    @Test
    fun getWinnerTest() {

        val car1 = Car("car1").apply { move(); move(); move() }
        val car2 = Car("car2").apply { move(); move() }
        val car3 = Car("car3").apply { move(); move(); move() }

        val cars = Cars()
        val carList = listOf(car1, car2, car3)
        val winners = cars.getWinners(carList)

        assertEquals("car1, car3", winners)
    }
}
