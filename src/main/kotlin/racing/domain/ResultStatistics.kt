package racing.domain

class ResultStatistics(private val cars: Cars) {

    fun toResult(): String {
        val stringBuilder = StringBuilder()
        for (car in cars.list()) {
            stringBuilder.appendLine(toMark(car))
        }
        return stringBuilder.toString()
    }

    private fun toMark(car: Car): String {
        return MARK.repeat(car.position)
    }

    companion object {
        const val MARK: String = "-"
    }
}
