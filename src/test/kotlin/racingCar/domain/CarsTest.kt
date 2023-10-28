package racingCar.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.domain.strategy.MoveStrategy

class CarsTest {

    companion object {
        private const val CAR_SIZE = 1
        private const val TRY_COUNT = 5
    }

    @Test
    fun moveCarTest() {
        val carList: List<Car> = List(CAR_SIZE) { Car() }
        val moveStrategy = MoveStrategy { true }
        val cars = Cars(moveStrategy)
        cars.moveCar(carList, TRY_COUNT)

        val car = carList[0]
        Assertions.assertEquals(car.moveCount, 5)
    }
}
