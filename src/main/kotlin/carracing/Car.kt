package carracing

class Car(_distance: Int = 0) {
    var distance: Int = _distance
        private set

    fun move(moveDistance: Int) {
        distance += moveDistance
    }
}
