package org.bmsk.racingcar.domain.model

data class RacingCarRoad(
    val cars: List<Car>,
) {
    fun getMovedRacingCarRoad(): RacingCarRoad {
        return RacingCarRoad(
            cars = cars.map { it.getMovedCar() },
        )
    }
}
