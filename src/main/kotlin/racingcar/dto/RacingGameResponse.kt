package racingcar.dto

import racingcar.domain.RacingGameReport

data class RacingGameResponse(
    val lapReports: List<List<Pair<String, Int>>>,
    val winners: List<String>
) {
    companion object {
        fun of(report: RacingGameReport): RacingGameResponse {
            return RacingGameResponse(lapReports(report), winners(report))
        }

        private fun winners(report: RacingGameReport): List<String> {
            return report.winner()
                .map { it.value }
        }

        private fun lapReports(report: RacingGameReport): List<List<Pair<String, Int>>> {
            return report.lapReports.map {
                it.lapReport.map { carNameWithLocation ->
                    carNameWithLocation.carName.value to carNameWithLocation.location.value
                }
            }
        }
    }
}
