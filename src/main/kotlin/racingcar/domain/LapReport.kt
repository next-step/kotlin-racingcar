package racingcar.domain

class LapReport(
    val lapReport: List<CarNameWithLocation>
) {
    fun winner(): List<CarName> {
        val topLocation = lapReport.maxOf { it.location }
        return lapReport.filter { it.location == topLocation }
            .map { it.carName }
    }
}
