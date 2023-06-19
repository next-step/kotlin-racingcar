package racingcar.domain

data class RacingResult(
    val cars: List<Car>
) {
    fun winners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
