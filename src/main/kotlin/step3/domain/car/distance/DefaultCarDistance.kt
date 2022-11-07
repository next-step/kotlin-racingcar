package step3.domain.car.distance

data class DefaultCarDistance(
    override var distance: Int = 0
) : CarDistance<Int> {

    override fun increment(addDistance: Int) {
        require(addDistance > 0) { "addDistance must be positive ($addDistance)" }
        distance += addDistance
    }
}
