package org.bmsk.racingcar.domain.model

data class RacingCarRoad(
    val cars: List<Car>,
) {
    init {
        require(cars.isNotEmpty()) { LIST_OF_CARS_CANNOT_BE_EMPTY }
    }

    fun getMovedRacingCarRoad(): RacingCarRoad {
        return RacingCarRoad(
            cars = cars.map { it.move() },
        )
    }

    companion object {
        private const val LIST_OF_CARS_CANNOT_BE_EMPTY = "자동차 리스트는 비어 있으면 안 됩니다."
    }
}
