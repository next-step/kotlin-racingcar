package racingcar.car

import racingcar.engine.DefaultEngine

class CarFactory(private val carList: List<Car>) {
    companion object {
        private val engine = DefaultEngine()

        fun create(carCount: Int): CarFactory {
            return CarFactory(initCarList(carCount))
        }

        private fun initCarList(carCount: Int): List<Car> {
            val tempList = mutableListOf<Car>()
            repeat(carCount) {
                tempList.add(Car(engine))
            }
            return tempList.toList()
        }
    }

    fun getResultCarList(): List<Car> {
        return carList.map { car ->
            car.start()
        }
    }

    fun getCarList(): List<Car> {
        return carList
    }
}
