package racing.domain

data class Car(
    val name: CarName,
    private var _route: Int = 0
) {
    constructor(value: String) : this(CarName(value), 0) {
    }

    val route: Int
        get() = _route

    fun getName(): String {
        return name.name
    }

    fun forward(movingRule: MovingRule) {
        if (movingRule.isMove())
            _route += 1
    }
}
