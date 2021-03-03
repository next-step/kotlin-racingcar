package racing.ui

import racing.domain.car.RacingCar

data class RacingCarDto(
    val name: String,
    val position: Int
) {
    companion object {
        fun of(racingCar: RacingCar) = RacingCarDto(racingCar.racingCarName.name, racingCar.position)
    }
}

data class RacingCarDtos(val racingCarDtos: List<RacingCarDto>)