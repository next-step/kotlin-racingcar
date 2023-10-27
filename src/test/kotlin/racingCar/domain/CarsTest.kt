package racingCar.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun moveCarsTest() {
        val carList: MutableList<Car> = ArrayList()
        val car = Car()
        carList.add(car)

        for (i in 1..100) {
            val cars = Cars()
            cars.moveCar(carList)
        }

        Assertions.assertNotEquals(car.moveCount, 0)
    }
}