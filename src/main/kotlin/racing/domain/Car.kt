package racing.domain

data class Car(
    val name: CarName,
    private var _route: Int = 0
) {
    public val route: Int
        get() {
            if (_route == 0) {
                _route = 0
            }
            return _route
        }
    fun forward(movingRule: MovingRule) {
        if (movingRule.isMove())
            _route += 1
    }
}
