package racingcar.entity

private const val ROAD = "-"
data class Car(var _distance: String = ROAD) {
    var distance = _distance
        private set
    fun move(distance: Int) {
        this.distance = this.distance + ROAD.repeat(distance)
    }
}
