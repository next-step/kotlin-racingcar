package car.racing.usecase

import car.racing.domain.Car

class FindRaceWinner {

    fun findByCars(
        cars: List<Car>,
        turnCount: Int,
    ): List<Car> {
        val turn = turnCount - 1
        val maxMoveDistance = cars
            .map { car -> car.getMoveDistanceUntilTurn(turn).filter { it }.size }
            .maxOrNull() ?: 0

        return cars.filter { car ->
            val moveDistance = car.getMoveDistanceUntilTurn(turn).filter { it }.size
            moveDistance == maxMoveDistance
        }
    }
}
