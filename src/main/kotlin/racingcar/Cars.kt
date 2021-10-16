package racingcar

import racingcar.model.Car
import racingcar.model.RaceCondition
import java.util.concurrent.ThreadLocalRandom

/**
 * 자동차들의 객체 관리
 * */
class Cars(raceCondition: RaceCondition) {
    private var _carList = (0 until raceCondition.carCount).map { Car() }.toList()
    val carList: List<Car>
        get() = this._carList

    private fun random(): Int {
        return ThreadLocalRandom.current().nextInt(0, 9)
    }

    fun race(): List<Car> {
        _carList = _carList.map { car ->
            car.move(random())
        }
        return _carList
    }
}
