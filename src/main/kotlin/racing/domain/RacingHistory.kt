package racing.domain

data class RacingHistory(
    val round: Int,
    val records: Map<Name, Distance>
)
