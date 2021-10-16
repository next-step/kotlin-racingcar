package racingcar

import racingcar.model.Car

/**
 * 자동차들의 객체 관리
 * */
class Cars(number: Int) {
    private val _carList = (0 until number).map { Car() }.toList()
    val carList = _carList
}
