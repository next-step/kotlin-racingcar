package racing.result

class RoundResult(
    val round: Int,
    val racingHistories: List<RacingHistory>
)

fun List<RacingHistory>.toRoundResult(round: Int): RoundResult {
    return RoundResult(round, this)
}