package car_racing

class Car(private var _distance: Int = 0) {
    val distance
        get() = _distance

    fun move(moveDistance: Int) {
        _distance += moveDistance
    }
}
