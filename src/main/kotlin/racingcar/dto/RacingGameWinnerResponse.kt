package racingcar.dto

import racingcar.domain.CarName

data class RacingGameWinnerResponse(
    val winners: List<String>
) {
    companion object {
        fun of(record: List<CarName>): RacingGameWinnerResponse {
            return RacingGameWinnerResponse(record.map { it.value })
        }
    }
}
