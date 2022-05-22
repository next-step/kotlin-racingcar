package racingcar.model

data class RacingGameResult(
    val results: List<RacingDataPerTry> = emptyList(),
    val winners: Cars
)
