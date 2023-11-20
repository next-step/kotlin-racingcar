package racing.dto

import racing.domain.Car

data class CarDto (val name: String, val route: Int) {
    companion object {
        fun from(car: Car): CarDto {
            return CarDto(
                name = car.name.name,
                route = car.route
            )
        }
    }
}
