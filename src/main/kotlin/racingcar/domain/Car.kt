package racingcar.domain

class Car(
    private val carNumber: Int
) {
    private var _moveForwardCount: Int = 0
    val moveForwardCount: Int
        get() = _moveForwardCount
    fun moveForward() = this._moveForwardCount++
}
