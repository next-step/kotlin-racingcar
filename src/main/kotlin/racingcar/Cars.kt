package racingcar

import racingcar.model.Car
import racingcar.model.RaceCondition

/**
 * 자동차들의 객체 관리
 * */
class Cars private constructor(var _carList: List<Car>) {
    companion object {
        fun createCars(raceCondition: RaceCondition): Cars {
            val carList = (0 until raceCondition.carCount).map { Car() }.toList()
            return Cars(carList)
        }
    }

    val carList: List<Car>
        get() = this._carList

    fun race(): List<Car> {
        _carList = _carList.map { car -> car.move() }
        return _carList
    }
}
