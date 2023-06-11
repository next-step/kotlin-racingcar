package racingcar.car

class Car(
    val name: String,
    private val engine: Engine = AMGEngine(),
    distance: Int = 0
) {
    private var _distance = distance
    val distance: Int
        get() = _distance

    init {
        require(name.isNotBlank()) { "이름은 필수값입니다." }
        require(name.length <= MINIMUM_NAME_LEN) { "이름 길이는 $MINIMUM_NAME_LEN 을 초과할수 없습니다" }
    }

    fun move() {
        if (engine.rpm >= MINIMUM_RPM) {
            _distance += 1
        }
    }

    companion object {
        private const val MINIMUM_RPM = 4
        private const val MINIMUM_NAME_LEN = 5
    }
}
