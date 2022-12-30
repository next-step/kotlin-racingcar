package racingcar.entity

import racingcar.common.ExceptionCode

private const val ROAD = "-"
private const val VALID_CAR_NAME_LENGTH = 5

data class Car(val name: String, var _distance: String = ROAD) {
    var distance = _distance
        private set

    init {
        require(name.length <= VALID_CAR_NAME_LENGTH) { throw ExceptionCode.NotExceedLengthCarName }
    }

    fun move(distance: Int) {
        this.distance = this.distance + ROAD.repeat(distance)
    }
}
