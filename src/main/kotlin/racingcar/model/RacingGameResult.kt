package racingcar.model

data class RacingGameResult(
    val result: List<RacingDataPerTry> = emptyList(),
    val winners: Cars
)
