package racingcar.util

import racingcar.constant.Constant
import racingcar.model.Car

class Cars(private val carList: MutableList<Car>) {
    companion object {
        fun create(carCount: Int): Cars {
            return Cars(initCarList(carCount))
        }

        private fun initCarList(carCount: Int): MutableList<Car> {
            val tempList = mutableListOf<Car>()
            for (i in Constant.START..carCount) {
                tempList.add(Car())
            }
            return tempList
        }
    }

    fun getResultCarList(): List<Car> {
        carList.map { car ->
            car.getResult()
        }.forEachIndexed { index, car ->
            carList[index] = car
        }
        return carList.toList()
    }

    fun getCarList(): List<Car> {
        return carList.toList()
    }
}
