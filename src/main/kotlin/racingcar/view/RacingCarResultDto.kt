package racingcar.view

data class RacingCarResultDto(
    val carNames: List<String>,
    val resultPerRound: List<List<Int>>,
    val winners: List<String>,
)
