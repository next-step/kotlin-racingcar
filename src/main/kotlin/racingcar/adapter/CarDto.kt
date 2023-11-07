package racingcar.adapter

import racingcar.domain.Car

data class CarDto(
    val name: String,
    val position: Int,
) {
    companion object {
        fun from(car: Car): CarDto {
            return CarDto(car.name.name, car.position.position)
        }
    }
}
