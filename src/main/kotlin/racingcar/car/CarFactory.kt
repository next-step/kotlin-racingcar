package racingcar.car

import racingcar.constant.Constant
import racingcar.engine.RandomEngine

class CarFactory(carCount: Int) {
    private val engine = RandomEngine()
    private val carList: List<Car> = initCarList(carCount)

    private fun initCarList(carCount: Int) = (Constant.START..carCount).map { Car(engine) }

    fun getResultCarList(): List<Car> {
        return carList.map { car ->
            car.start()
        }
    }

    fun getCarList(): List<Car> {
        return carList
    }
}
