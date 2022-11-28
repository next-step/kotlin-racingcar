package step3.domain.car.distance

data class CarDistance(
    private var _distance: Int = 0
) : Comparable<CarDistance> {
    val distance: Int
        get() = _distance

    fun increment(addDistance: Int) {
        require(addDistance > 0) { "addDistance must be positive ($addDistance)" }
        _distance += addDistance
    }

    override fun compareTo(other: CarDistance): Int {
        return distance.compareTo(other.distance)
    }
}
