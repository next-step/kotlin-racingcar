package game.racingcar.dto

data class RacingCarPlayResult(
    val locationSnapshots: List<LocationSnapshot>,
    val winners: List<String>
)
