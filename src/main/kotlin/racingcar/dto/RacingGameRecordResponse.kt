package racingcar.dto

import racingcar.domain.CarRecord
import racingcar.domain.LapRecord
import racingcar.domain.RacingGameRecord

data class RacingGameRecordResponse(
    val lapRecords: List<LapRecordResponse>,
    val winners: List<String>
) {
    companion object {
        fun of(record: RacingGameRecord): RacingGameRecordResponse {
            return RacingGameRecordResponse(lapRecords(record), winners(record))
        }

        private fun winners(record: RacingGameRecord): List<String> {
            return record.winner()
                .map { it.value }
        }

        private fun lapRecords(record: RacingGameRecord): List<LapRecordResponse> {
            return LapRecordResponse.listOf(record)
        }
    }
}

data class LapRecordResponse(
    val carRecords: List<CarRecordResponse>
) {
    companion object {
        fun of(lapRecord: LapRecord): LapRecordResponse {
            return LapRecordResponse(CarRecordResponse.listOf(lapRecord))
        }

        fun listOf(report: RacingGameRecord): List<LapRecordResponse> {
            return report.lapRecords.map { of(it) }
        }
    }
}

data class CarRecordResponse(
    val carName: String,
    val location: Int,
) {
    companion object {
        fun of(carRecord: CarRecord): CarRecordResponse {
            return CarRecordResponse(carRecord.carName.value, carRecord.location.value)
        }

        fun listOf(lapRecord: LapRecord): List<CarRecordResponse> {
            return lapRecord.lapRecord.map { of(it) }
        }
    }
}
