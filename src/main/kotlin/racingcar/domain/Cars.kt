package racingcar.domain

data class Cars(
    val cars: List<Car>
) {

    fun extractByMaxPosition(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
