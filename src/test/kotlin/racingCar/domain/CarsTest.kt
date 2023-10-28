package racingCar.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import racingCar.domain.strategy.MoveStrategy

class CarsTest {

    companion object {
        private const val CAR_SIZE = 1
        private const val TRY_COUNT = 5
        private const val CARS = "pobi,crong,honux"
        private const val LENGTH_OVER_CARS = "pobiaaa,crongbbb,honuxccc"
    }

    @Test
    fun moveCarTest() {
        val carList: List<Car> = List(CAR_SIZE) { Car("testCar") }
        val moveStrategy = MoveStrategy { true }
        val cars = Cars(moveStrategy)
        cars.moveCar(carList, TRY_COUNT)

        val car = carList[0]
        Assertions.assertEquals(car.moveCount, 5)
    }

    @Test
    fun getCarsTest() {
        val cars = Cars()
        val carList = cars.getCars(CARS);

        Assertions.assertEquals(3, carList.size)
    }

    @Test
    fun `자동차 Name의 길이는 5 초과가 되어선 안된다`() {
        val cars = Cars()
        assertThrows<IllegalArgumentException> {
            cars.getCars(LENGTH_OVER_CARS);
        }
    }
}
