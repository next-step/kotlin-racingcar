package study.racingcar

class Car {

    private var _distance: Int = 0
    val distance: Int get() = _distance

    fun moveCar() {
        _distance++
    }
}
