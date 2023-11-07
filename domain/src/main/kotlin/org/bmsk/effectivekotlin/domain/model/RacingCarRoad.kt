package org.bmsk.effectivekotlin.domain.model

import org.bmsk.effectivekotlin.model.Position

data class RacingCarRoad(
    val cars: List<Car>,
) {
    init {
        require(cars.isNotEmpty()) { LIST_OF_CARS_CANNOT_BE_EMPTY }
    }

    fun makeAllCarsMove(): RacingCarRoad {
        return RacingCarRoad(
            cars = cars.map { it.move() },
        )
    }

    fun findCarsWentFurthest(): Cars {
        val furthestCars = cars.filter { it.position == findFurthestPosition() }
        return Cars(furthestCars)
    }

    private fun findFurthestPosition(): Position {
        return cars.maxBy { it.position.xPos }.position
    }

    companion object {
        private const val LIST_OF_CARS_CANNOT_BE_EMPTY = "자동차 리스트는 비어 있으면 안 됩니다."
    }
}
