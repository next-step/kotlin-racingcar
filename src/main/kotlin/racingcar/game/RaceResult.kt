package racingcar.game

data class RaceResult(
    val cars: List<CarDto>,
)

data class CarDto(
    val position: Int,
    val name: String,
)
