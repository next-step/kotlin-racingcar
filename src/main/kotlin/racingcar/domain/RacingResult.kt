package racingcar.domain

class RacingResult {
    private var _elements = mutableListOf<Cars>()

    val elements
        get() = _elements.toList()

    fun winners(): Winners {
        val maxDistance = _elements.last()
            .maxDistance

        return Winners(
            _elements.last()
                .findAllByDistance(maxDistance)
        )
    }

    fun add(cars: Cars) {
        _elements.add(cars)
    }
}
