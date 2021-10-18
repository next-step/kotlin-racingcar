package racingcar.model

data class RacingCarGameSnapshot(
    val round: Int,
    private val cars: Cars
) {
    fun forEach(action: (Car) -> Unit) = cars.forEach(action)
}
