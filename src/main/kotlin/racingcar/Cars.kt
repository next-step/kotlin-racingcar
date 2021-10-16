package racingcar

import racingcar.model.Car
import racingcar.model.RaceCondition

/**
 * 자동차들의 객체 관리
 * */
class Cars(raceCondition: RaceCondition) {
    private var _carList = (0 until raceCondition.carCount).map { Car() }.toList()
    val carList: List<Car>
        get() = this._carList

    fun race(): List<Car> {
        _carList = _carList.map { car ->
            car.move(DriveRule.random())
        }
        return _carList
    }
}
