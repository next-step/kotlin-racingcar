package racing.dto

data class RoundInfo(
    val round: Int,
    val carInfos: List<RacingCarInfo>,
)
