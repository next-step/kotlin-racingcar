package racingcar.car

class Car(
    private val engine: Engine,
    private var _distance: Int = 0
) {
    val distance: Int
        get() = _distance

    fun move() {
        if (engine.rpm >= 4) {
            _distance += 1
        }
    }
}
