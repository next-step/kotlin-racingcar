package racing.domain

data class Winners(private val cars: Cars) {

    fun names(): List<String> {
        val maxPosition = cars.maxPosition()
        return cars.value()
            .filter { it.samePosition(maxPosition) }
            .map { it.name() }
    }
}
