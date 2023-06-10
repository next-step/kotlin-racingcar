package racingcar.car

class Car(
    private val engine: Engine,
    distance: Int = 0
) {
    private var _distance = distance
    val distance: Int
        get() = _distance

    fun move() {
        if (engine.rpm >= MINIMUM_RPM) {
            _distance += 1
        }
    }

    companion object {
        private const val MINIMUM_RPM: Int = 4
    }
}
