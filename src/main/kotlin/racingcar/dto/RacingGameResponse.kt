package racingcar.dto

import racingcar.domain.LapRecord
import racingcar.domain.RacingGameRecord

data class RacingGameResponse(
    val lapRecords: List<List<Pair<String, Int>>>,
    val winners: List<String>
) {
    companion object {
        fun of(record: RacingGameRecord): RacingGameResponse {
            return RacingGameResponse(lapRecords(record), winners(record))
        }

        private fun winners(record: RacingGameRecord): List<String> {
            return record.winner()
                .map { it.value }
        }

        private fun lapRecords(record: RacingGameRecord): List<List<Pair<String, Int>>> {
            return record.lapRecords.map { lapRecord(it) }
        }

        private fun lapRecord(lapRecord: LapRecord): List<Pair<String, Int>> {
            return lapRecord.lapRecord.map { carNameWithLocation ->
                carNameWithLocation.carName.value to carNameWithLocation.location.value
            }
        }
    }
}
