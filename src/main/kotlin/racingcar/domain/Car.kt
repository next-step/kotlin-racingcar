package racingcar.domain

class Car(val name: String) {
    private var _moveForwardCount: Int = 0
    val moveForwardCount: Int
        get() = _moveForwardCount
    fun moveForward() = this._moveForwardCount++
}
