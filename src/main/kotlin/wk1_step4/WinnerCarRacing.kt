package wk1_step4

import java.lang.IndexOutOfBoundsException

object WinnerCarRacing {

    private fun generateRandomNumber(): Int {
        return ((Math.random() * 10).toInt())
    }

    private fun moveOrStop(car: Car) {
        if (generateRandomNumber() > 3) car.position = car.position + 1
    }

    fun updateCarRacing(cars: List<Car>) {
        if (cars.isEmpty()) {
            throw WinnerCarRacingException("자동차 이름을 입력하세요.")
        }
        for (car in cars) {
            moveOrStop(car)
        }
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getMaxDistance(cars: List<Car>): Int {
        return cars.maxBy { it.position }!!.position
    }

    @Throws(IndexOutOfBoundsException::class)
    fun resultOfRacing(cars: List<Car>): List<Car> {
        return cars.filter { it.position == getMaxDistance(cars) }.toList()
    }
}
