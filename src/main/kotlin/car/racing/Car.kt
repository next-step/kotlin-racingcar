package car.racing

class Car(val driverName: String, private val condition: CarCondition = CarCondition.NORMAL) {
    private var _moves: Int = 0
    val moves: Int
        get() = _moves

    init {
        require(driverName.isNotBlank())
    }

    fun run() {
        if (condition.canGoForward()) {
            _moves += 1
        }
    }
}

fun Car.getRecord(): Record = Record(driverName, moves)
