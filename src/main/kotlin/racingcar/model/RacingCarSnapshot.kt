package racingcar.model

data class RacingCarSnapshot(
    val round: Int,
    private val cars: List<Car>
) {
    fun forEach(action: (Car) -> Unit) = cars.forEach(action)
}
