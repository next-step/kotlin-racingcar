package racing.domain

class ResultStatistics(private val cars: Cars) {

    fun toResult(): String {
        return cars.map { toMark(it) }.joinToString(separator = System.lineSeparator())
    }

    private fun toMark(car: Car): String {
        return MARK.repeat(car.position)
    }

    companion object {
        const val MARK: String = "-"
    }
}
