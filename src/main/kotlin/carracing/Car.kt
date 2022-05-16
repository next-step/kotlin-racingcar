package carracing

class Car(_name: String, _distance: Int = 0) {
    val name: String = _name
    var distance: Int = _distance
        private set

    fun move(moveDistance: Int) {
        distance += moveDistance
    }
}
