package game.racingcar.dto

data class RacingCarPlayResult(
    val carLocationSnapshots: List<CarLocationSnapshot>,
    val winners: List<String>
)
