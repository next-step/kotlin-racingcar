package racing.domain

class ResultStatistics(private val cars: Cars) {

    fun toResult(): String {
        return cars.map { "${it.name}: ${toMark(it)}" }.joinToString(separator = System.lineSeparator()).trimIndent()
    }

    private fun toMark(car: Car): String {
        return MARK.repeat(car.position)
    }

    companion object {
        const val MARK: String = "-"
    }
}
