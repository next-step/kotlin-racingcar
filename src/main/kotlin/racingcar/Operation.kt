package racingcar

import kotlin.random.Random.Default.nextInt

object Operation {
    fun initCar(carCount: Int): List<Car> {
        return (1..carCount).map { Car() }
    }

    fun moveCar(cars: List<Car>): List<Car> {
        return cars.map { car ->
            if (isMove()) car.move() else car
        }
    }

    private fun isMove(): Boolean {
        return nextInt(0, 10) >= 4
    }
}
