package racingcar.domain

class RacingGameReport(
    lapReports: List<LapReport> = listOf()
) {
    private val _lapReports = lapReports.toMutableList()
    val lapReports get() = _lapReports.toList()

    fun add(lapReport: LapReport) {
        _lapReports.add(lapReport)
    }

    fun winner(): List<CarName> {
        return lapReports.last()
            .winner()
    }
}
