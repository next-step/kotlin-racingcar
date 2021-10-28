package racingcar.car

import racingcar.engine.RandomEngine

class Cars(carCount: Int) {
    val carList: List<Car> = CarFactory.initCarList(carCount, RandomEngine())

    fun getRacingResult(): List<Car> {
        return carList.map { car ->
            car.start()
        }
    }
}
