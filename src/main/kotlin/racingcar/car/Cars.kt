package racingcar.car

import racingcar.engine.RandomEngine

class Cars(carCount: Int) {
    private val carList: List<Car> = CarFactory.initCarList(carCount, RandomEngine())

    fun getCarList(): List<Car> {
        return carList
    }

    fun getRacingResult(): List<Car> {
        return carList.map { car ->
            car.start()
        }
    }
}
