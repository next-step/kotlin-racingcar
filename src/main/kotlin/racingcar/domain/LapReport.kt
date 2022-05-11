package racingcar.domain

class LapReport(
    private val lapReport: List<Pair<CarName, Location>>
) {
    fun winner(): List<CarName> {
        val topLocation = topLocation()
        return lapReport.filter { it.second == topLocation }
            .map { it.first }
    }

    private fun topLocation(): Location {
        return lapReport.maxOf { it.second }
    }
}
