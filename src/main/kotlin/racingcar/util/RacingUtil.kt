package racingcar.util

import racingcar.constant.Constant
import racingcar.model.Car

object RacingUtil {
    fun getResultCarList(resultCarList: MutableList<Car>): List<Car> {
        resultCarList.map { car ->
            car.getResult()
        }.forEachIndexed { index, car ->
            resultCarList[index] = car
        }
        return resultCarList
    }

    fun getCarList(carCount: Int): MutableList<Car> {
        val carList = mutableListOf<Car>()
        for (i in Constant.START..carCount) {
            carList.add(Car())
        }
        return carList
    }
}
