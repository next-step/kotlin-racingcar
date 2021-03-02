package racing.ui.model

import racing.data.RacingHistory

data class RacingHistoryDTO(
    val roundResultDTOs: List<RoundResultDTO>
) {
    companion object {
        fun of(racingHistory: RacingHistory): RacingHistoryDTO {
            val roundResults = racingHistory.roundResults
            val roundResultDTOs = roundResults.map { RoundResultDTO.of(it) }.toList()
            return RacingHistoryDTO(roundResultDTOs)
        }
    }
}
