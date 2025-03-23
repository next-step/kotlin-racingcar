package racingcar.game

import racingcar.car.Car

data class RaceResult(
    val cars: List<CarDto>,
)

data class CarDto(
    val position: Int,
    val name: String,
)

fun List<Car>.toRaceResult(): RaceResult {
    val cars = this.map { CarDto(it.position, it.name) }
    return RaceResult(cars)
}
