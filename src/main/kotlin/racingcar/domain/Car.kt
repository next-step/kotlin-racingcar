package racingcar.domain

import racingcar.dto.MoveResults

class Car(
    private val carName: String
) {
    private var _drivingRecord: Int = 0
    private val drivingRecord: Int = _drivingRecord

    val moveResult get() = MoveResults.MoveResult(carName, drivingRecord)

    fun move() {
        _drivingRecord++
    }
}
