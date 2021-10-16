package racingcar

import racingcar.model.Car
import racingcar.model.RaceCondition
import racingcar.model.move

/**
 * 자동차들의 객체 관리
 * */
class Cars(raceCondition: RaceCondition) {
    private var _carList = (0 until raceCondition.carCount).map { Car() }.toList()
    val carList = _carList

    fun race(): List<Car> {
        _carList = _carList.map { car ->
            car.move(car.random())
        }
        return _carList
    }
}
