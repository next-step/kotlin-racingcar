package study.racingcar

class Car {

    private var _distance: Int = 0
    val distance: Int get() = _distance

    fun moveCar(random: Int) {
        if (random >= MOVE_ALLOWABLE_VALUE) {
            _distance++
        }
    }

    companion object {
        private const val MOVE_ALLOWABLE_VALUE = 4
    }
}
