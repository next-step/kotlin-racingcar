package study.racingcar.domain

data class Round(
    val number: Int,
    val cars: List<Car>
) {
    fun winners(): Set<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.toSet()
    }
}
