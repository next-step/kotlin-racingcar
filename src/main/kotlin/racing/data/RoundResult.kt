package racing.data

import racing.domain.Car

data class RoundResult(
    val carPositions: Map<String, Int>
) {
    companion object {
        fun of(cars: List<Car>): RoundResult {
            val carPositions = cars.map { it.name to it.position }.toMap()
            return RoundResult(carPositions)
        }
    }
}
