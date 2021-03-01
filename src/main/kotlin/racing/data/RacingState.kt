package racing.data

import racing.domain.Car

data class RacingState(
    val carPositions: Map<String, Int>
) {
    companion object {
        fun of(cars: List<Car>): RacingState {
            val carPositions = cars.map { it.name to it.position }.toMap()
            return RacingState(carPositions)
        }
    }
}
