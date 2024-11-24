package racingcar.domain

import racingcar.domain.dto.CarPosition
import racingcar.domain.dto.Winner

class RaceResultPerRound(
    val carPositions: List<CarPosition>,
) {
    fun findWinners(): List<Winner> {
        val maxPosition =
            carPositions.maxOfOrNull { it.position }
                ?: return emptyList()

        return carPositions
            .filter { it.position == maxPosition }
            .map { Winner(it.name) }
    }

    companion object {
        fun fromCars(cars: List<Car>): RaceResultPerRound {
            return RaceResultPerRound(cars.map { CarPosition.from(it) })
        }
    }
}
