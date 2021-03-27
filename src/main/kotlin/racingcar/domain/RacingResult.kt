package racingcar.domain

class RacingResult {
    private var _elements = mutableListOf<Cars>()

    val elements
        get() = _elements.toList()

    val winner: Winner
        get() {
            val maxDistance = _elements.last()
                .maxDistance

            return Winner(
                _elements.last()
                    .findAllByDistance(maxDistance)
            )
        }

    fun add(cars: Cars) {
        _elements.add(cars)
    }
}
