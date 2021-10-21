package car.racing.usecase

import car.racing.domain.Car

class FindRaceWinner {

    fun findByCars(
        cars: List<Car>,
        turnCount: Int,
    ): List<Car> {
        val maxMoveDistance = cars
            .map { car -> getMoveDistance(car, turnCount) }
            .maxOrNull() ?: 0

        return cars.filter { car ->
            val moveDistance = getMoveDistance(car, turnCount)
            moveDistance == maxMoveDistance
        }
    }

    private fun getMoveDistance(car: Car, turnCount: Int): Int {
        val turn = turnCount - 1

        return car.getMoveDistanceUntilTurn(turn).filter { it }.size
    }
}
