package racing.domain

data class RacingResult(
    val racingHistories: List<RacingHistory>,
    val winners: List<Name>
)
