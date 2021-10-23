package racingcar.racing

import racingcar.car.Car

object Racing {
    fun racingStart(carCount: Int, tryCount: Int) {
        val cars = initCars(carCount)
    }

    private fun initCars(carCount: Int): List<Car> {
        var cars = mutableListOf<Car>()
        for (i: Int in 1 until carCount) {
            cars.add(Car())
        }
        return cars
    }
}
