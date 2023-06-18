package racingame.domain

class RacingHistory(
    private val cars: List<Car> = emptyList()
) {
    val history get() = cars.toList()
}
