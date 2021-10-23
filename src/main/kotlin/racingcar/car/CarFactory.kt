package racingcar.car

import racingcar.constant.Constant
import racingcar.engine.RandomEngine

class CarFactory(private val carList: List<Car>) {
    fun getResultCarList(): List<Car> {
        return carList.map { car ->
            car.start()
        }
    }

    fun getCarList(): List<Car> {
        return carList
    }

    companion object {
        private val engine = RandomEngine()

        fun create(carCount: Int): CarFactory {
            return CarFactory(initCarList(carCount))
        }

        private fun initCarList(carCount: Int) = (Constant.START..carCount).map { Car(engine) }
    }
}
