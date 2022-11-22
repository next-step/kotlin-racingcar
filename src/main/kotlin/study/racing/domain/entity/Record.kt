package study.racing.domain.entity

data class Record(
    val name: String,
    val position: Int,
) {
    companion object {
        operator fun invoke(racingCar: RacingCar) = Record(
            name = racingCar.name,
            position = racingCar.currentPosition
        )
    }
}
