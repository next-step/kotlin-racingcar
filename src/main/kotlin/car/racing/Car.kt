package car.racing

class Car(private val condition: CarCondition = CarCondition.NORMAL) {
    private var _moves: Int = 0
    val moves: Int
        get() = _moves

    fun run() {
        if (condition.canGoForward()) {
            _moves += 1
        }
    }
}
