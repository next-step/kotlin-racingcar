package org.bmsk.racingcar.domain.model

import org.bmsk.racingcar.domain.error.RacingCarErrorMessage

data class RacingCarRoad(
    val cars: List<Car>,
) {
    init {
        require(cars.isNotEmpty()) { RacingCarErrorMessage.LIST_OF_CARS_CANNOT_BE_EMPTY.message }
    }

    fun getMovedRacingCarRoad(): RacingCarRoad {
        return RacingCarRoad(
            cars = cars.map { it.getMovedCar() },
        )
    }
}
