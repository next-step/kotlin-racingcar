package racingcar.dto

import racingcar.domain.CarRecord
import racingcar.domain.LapRecord

data class RacingGameRecordResponse(
    val lapRecords: List<LapRecordResponse>,
) {
    companion object {
        fun of(lapRecords: List<LapRecord>): RacingGameRecordResponse {
            return RacingGameRecordResponse(lapRecords.map(LapRecordResponse::of))
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
            return lapRecord.carRecords.map { of(it) }
        }
    }
}
